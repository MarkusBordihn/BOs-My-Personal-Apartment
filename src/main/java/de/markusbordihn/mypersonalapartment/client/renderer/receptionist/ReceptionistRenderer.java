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

package de.markusbordihn.mypersonalapartment.client.renderer.receptionist;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.mypersonalapartment.client.renderer.entity.HumanoidSlimRenderer;
import de.markusbordihn.mypersonalapartment.entity.ApartmentNPCEntity;
import de.markusbordihn.mypersonalapartment.entity.npc.receptionist.ReceptionistEntity;
import de.markusbordihn.mypersonalapartment.entity.npc.receptionist.ReceptionistVariant;

@OnlyIn(Dist.CLIENT)
public class ReceptionistRenderer extends HumanoidSlimRenderer {

  // Variant Textures
  protected static final Map<ReceptionistVariant, ResourceLocation> TEXTURE_BY_VARIANT =
      Util.make(new EnumMap<>(ReceptionistVariant.class), hashMap -> {
        hashMap.put(ReceptionistVariant.ALEX,
            new ResourceLocation("minecraft:textures/entity/player/slim/alex.png"));
        hashMap.put(ReceptionistVariant.ARI,
            new ResourceLocation("minecraft:textures/entity/player/slim/ari.png"));
        hashMap.put(ReceptionistVariant.EFE,
            new ResourceLocation("minecraft:textures/entity/player/slim/efe.png"));
        hashMap.put(ReceptionistVariant.KAI,
            new ResourceLocation("minecraft:textures/entity/player/slim/kai.png"));
        hashMap.put(ReceptionistVariant.MAKENA,
            new ResourceLocation("minecraft:textures/entity/player/slim/makena.png"));
        hashMap.put(ReceptionistVariant.NOOR,
            new ResourceLocation("minecraft:textures/entity/player/slim/noor.png"));
        hashMap.put(ReceptionistVariant.STEVE,
            new ResourceLocation("minecraft:textures/entity/player/slim/steve.png"));
        hashMap.put(ReceptionistVariant.SUNNY,
            new ResourceLocation("minecraft:textures/entity/player/slim/sunny.png"));
        hashMap.put(ReceptionistVariant.ZURI,
            new ResourceLocation("minecraft:textures/entity/player/slim/zuri.png"));
      });
  protected static final ResourceLocation DEFAULT_TEXTURE =
      TEXTURE_BY_VARIANT.get(ReceptionistVariant.ALEX);

  public ReceptionistRenderer(Context context) {
    super(context);
  }

  @Override
  public ResourceLocation getTextureLocation(ApartmentNPCEntity entity) {
    if (entity instanceof ReceptionistEntity receptionistEntity) {
      return TEXTURE_BY_VARIANT.getOrDefault(receptionistEntity.getVariant(), DEFAULT_TEXTURE);
    }
    return DEFAULT_TEXTURE;
  }

}
