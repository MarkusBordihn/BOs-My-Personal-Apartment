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

package de.markusbordihn.mypersonalapartment.tabs;

import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;

import de.markusbordihn.mypersonalapartment.item.ModItems;

public class ApartmentItems implements DisplayItemsGenerator {
  protected ApartmentItems() {}

  @Override
  public void accept(ItemDisplayParameters itemDisplayParameters, Output output) {
    // Creative Apartment Items
    output.accept(ModItems.KEY_HOLDER_BASIC.get());
    output.accept(ModItems.RECEPTIONIST_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_ALEX_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_ARI_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_EFE_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_KAI_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_MAKENA_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_NOOR_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_STEVE_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_SUNNY_SPAWN_EGG.get());
    output.accept(ModItems.RECEPTIONIST_ZURI_SPAWN_EGG.get());
  }
}
