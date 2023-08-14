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

package de.markusbordihn.mypersonalapartment.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.block.ModBlocks;
import de.markusbordihn.mypersonalapartment.entity.npc.ModEntityType;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  // Creative Apartment Items and NPCs
  public static final RegistryObject<Item> KEY_HOLDER_BASIC = ITEMS.register("key_holder_basic",
      () -> new BlockItem(ModBlocks.KEY_HOLDER_BASIC.get(), new Item.Properties()));

  // Receptionist Spawn Eggs
  public static final RegistryObject<Item> RECEPTIONIST_SPAWN_EGG = ITEMS
      .register("receptionist_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST,
          0x000000, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_ALEX_SPAWN_EGG = ITEMS.register(
      "receptionist_alex_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_ALEX,
          0xff0000, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_ARI_SPAWN_EGG = ITEMS.register(
      "receptionist_ari_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_ARI,
          0x0f00f0, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_EFE_SPAWN_EGG = ITEMS.register(
      "receptionist_efe_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_EFE,
          0x00ff00, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_KAI_SPAWN_EGG = ITEMS.register(
      "receptionist_kai_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_KAI,
          0x0000ff, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_MAKENA_SPAWN_EGG =
      ITEMS.register("receptionist_makena_spawn_egg",
          () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_MAKENA, 0x000000, 0xffffff,
              new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_NOOR_SPAWN_EGG = ITEMS.register(
      "receptionist_noor_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_NOOR,
          0xffff00, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_STEVE_SPAWN_EGG = ITEMS.register(
      "receptionist_steve_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_STEVE,
          0xff00ff, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_SUNNY_SPAWN_EGG = ITEMS.register(
      "receptionist_sunny_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_SUNNY,
          0x00ffff, 0xffffff, new Item.Properties()));
  public static final RegistryObject<Item> RECEPTIONIST_ZURI_SPAWN_EGG = ITEMS.register(
      "receptionist_zuri_spawn_egg", () -> new ForgeSpawnEggItem(ModEntityType.RECEPTIONIST_ZURI,
          0xffffff, 0xffffff, new Item.Properties()));
}
