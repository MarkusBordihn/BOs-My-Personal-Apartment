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

import com.google.common.collect.Sets;

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
import de.markusbordihn.mypersonalapartment.config.CommonConfig;

@Mod.EventBusSubscriber()
public class VillageTemplatePool {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  protected VillageTemplatePool() {

  }

  @SubscribeEvent
  public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
    Registry<StructureTemplatePool> structureTemplatePool =
        event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
    Registry<StructureProcessorList> structureProcessorList =
        event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

    // Add dessert reception buildings
    if (Boolean.TRUE.equals(COMMON.receptionDesertEnabled.get())) {
      addReceptionDessertStructures(structureTemplatePool, structureProcessorList);
    }

    // Add plains reception buildings
    if (Boolean.TRUE.equals(COMMON.receptionPlainsEnabled.get())) {
      addReceptionPlainsStructures(structureTemplatePool, structureProcessorList);
    }

    // Add savanna reception buildings
    if (Boolean.TRUE.equals(COMMON.receptionSavannaEnabled.get())) {
      addReceptionSavannaStructures(structureTemplatePool, structureProcessorList);
    }

    // Add snowy reception buildings
    if (Boolean.TRUE.equals(COMMON.receptionSnowyEnabled.get())) {
      addReceptionSnowyStructures(structureTemplatePool, structureProcessorList);
    }

    // Add taiga reception buildings
    if (Boolean.TRUE.equals(COMMON.receptionTaigaEnabled.get())) {
      addReceptionTaigaStructures(structureTemplatePool, structureProcessorList);
    }
  }

  private static void addReceptionDessertStructures(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList) {
    ResourceLocation templatePool = new ResourceLocation("minecraft:village/desert/houses");
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionDesertSmallModel.get())),
        COMMON.receptionDesertSmallModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionDesertMediumModel.get())),
        COMMON.receptionDesertMediumModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionDesertLargeModel.get())),
        COMMON.receptionDesertLargeModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionDesertInfoModel.get())),
        COMMON.receptionDesertInfoModelSpawnWeight.get());
  }

  private static void addReceptionPlainsStructures(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList) {
    ResourceLocation templatePool = new ResourceLocation("minecraft:village/plains/houses");
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionPlainsSmallModel.get())),
        COMMON.receptionPlainsSmallModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionPlainsMediumModel.get())),
        COMMON.receptionPlainsMediumModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionPlainsLargeModel.get())),
        COMMON.receptionPlainsLargeModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionPlainsInfoModel.get())),
        COMMON.receptionPlainsInfoModelSpawnWeight.get());
  }

  private static void addReceptionSavannaStructures(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList) {
    ResourceLocation templatePool = new ResourceLocation("minecraft:village/savanna/houses");
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSavannaSmallModel.get())),
        COMMON.receptionSavannaSmallModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSavannaMediumModel.get())),
        COMMON.receptionSavannaMediumModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSavannaLargeModel.get())),
        COMMON.receptionSavannaLargeModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSavannaInfoModel.get())),
        COMMON.receptionSavannaInfoModelSpawnWeight.get());
  }

  private static void addReceptionSnowyStructures(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList) {
    ResourceLocation templatePool = new ResourceLocation("minecraft:village/snowy/houses");
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSnowySmallModel.get())),
        COMMON.receptionSnowySmallModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSnowyMediumModel.get())),
        COMMON.receptionSnowyMediumModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSnowyLargeModel.get())),
        COMMON.receptionSnowyLargeModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionSnowyInfoModel.get())),
        COMMON.receptionSnowyInfoModelSpawnWeight.get());
  }

  private static void addReceptionTaigaStructures(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList) {
    ResourceLocation templatePool = new ResourceLocation("minecraft:village/taiga/houses");
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionTaigaSmallModel.get())),
        COMMON.receptionTaigaSmallModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionTaigaMediumModel.get())),
        COMMON.receptionTaigaMediumModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionTaigaLargeModel.get())),
        COMMON.receptionTaigaLargeModelSpawnWeight.get());
    addReceptionStructures(structureTemplatePool, structureProcessorList, templatePool,
        new ArrayList<>(Sets.newHashSet(COMMON.receptionTaigaInfoModel.get())),
        COMMON.receptionTaigaInfoModelSpawnWeight.get());
  }

  private static void addReceptionStructures(Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList, ResourceLocation templatePool,
      List<String> models, int weight) {


    // Add buildings to pool
    if (weight > 0 && !models.isEmpty()) {
      log.info("Add buildings {} to {} with weight {} ...", models, templatePool, weight);
      for (String model : models) {
        addStructureToTemplatePool(structureTemplatePool, structureProcessorList, templatePool,
            model, COMMON.receptionDesertSmallModelSpawnWeight.get());
      }
    }
  }


  private static void addStructureToTemplatePool(
      Registry<StructureTemplatePool> structureTemplatePool,
      Registry<StructureProcessorList> structureProcessorList, ResourceLocation templatePool,
      String structure, int weight) {

    // Get the pool and check if it exists.
    StructureTemplatePool pool = structureTemplatePool.get(templatePool);
    if (pool == null) {
      log.warn("Pool {} not found!", templatePool);
      return;
    }

    // Create a piece with the structure and an empty processor list.
    Holder<StructureProcessorList> emptyProcessorList = structureProcessorList.getHolderOrThrow(
        ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty")));
    SinglePoolElement piece = StructurePoolElement.legacy(structure, emptyProcessorList)
        .apply(StructureTemplatePool.Projection.RIGID);

    // Add the piece to the pool weight x times.
    for (int i = 0; i < weight; i++) {
      pool.templates.add(piece);
    }

    // Add the piece to the raw list.
    List<Pair<StructurePoolElement, Integer>> structureList = new ArrayList<>(pool.rawTemplates);
    structureList.add(new Pair<>(piece, weight));
    pool.rawTemplates = structureList;
  }

}
