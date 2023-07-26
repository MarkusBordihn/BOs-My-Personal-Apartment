/**
 * Copyright 2023 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.mypersonalapartment.worldgen;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import de.markusbordihn.mypersonalapartment.Constants;

@Mod.EventBusSubscriber()
public class VillageTemplatePool {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected VillageTemplatePool() {

  }

  @SubscribeEvent
  public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
    Registry<StructureTemplatePool> structureTemplatePool =
        event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
    Registry<StructureProcessorList> structureProcessorList =
        event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

    addStructureToTemplatePool(structureTemplatePool, structureProcessorList,
        new ResourceLocation("minecraft:village/plains/houses"),
        "my_personal_apartment:apartments_base", 3);
  }

  private static void addStructureToTemplatePool(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList, ResourceLocation templatePool,
      String structure, int weight) {
    log.info("Add building {} to pool {} with weight {} ...", structure, templatePool, weight);

    StructureTemplatePool pool = structureTemplatePool.get(templatePool);
    if (pool == null) {
      log.warn("Pool {} not found!", templatePool);
      return;
    }

    Holder<StructureProcessorList> emptyProcessorList = structureProcessorList.getHolderOrThrow(
        ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty")));
    SinglePoolElement piece = StructurePoolElement.legacy(structure, emptyProcessorList)
        .apply(StructureTemplatePool.Projection.RIGID);

    // Add the piece to the pool weight x times
    for (int i = 0; i < weight; i++) {
      pool.templates.add(piece);
    }

    List<Pair<StructurePoolElement, Integer>> structureList = new ArrayList<>(pool.rawTemplates);
    structureList.add(new Pair<>(piece, weight));
    pool.rawTemplates = structureList;
  }

}
