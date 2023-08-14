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

package de.markusbordihn.mypersonalapartment.entity.npc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.entity.ApartmentNPCEntityData;
import de.markusbordihn.mypersonalapartment.entity.npc.receptionist.ReceptionistEntity;
import de.markusbordihn.mypersonalapartment.entity.npc.receptionist.ReceptionistVariant;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityType {

  protected ModEntityType() {

  }

  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);

  // Receptionist NPC Entity
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST =
      ENTITY_TYPES.register(ReceptionistEntity.ID,
          () -> EntityType.Builder
              .<ReceptionistEntity>of(ReceptionistEntity::new, ApartmentNPCEntityData.CATEGORY)
              .sized(1.0F, 2.0F).clientTrackingRange(8).build(ReceptionistEntity.ID));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_ALEX =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_alex", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.ALEX, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_alex"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_ARI =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_ari", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.ARI, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_ari"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_EFE =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_efe", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.EFE, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_efe"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_KAI =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_kai", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.KAI, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_kai"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_MAKENA =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_makena", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.MAKENA, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_makena"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_NOOR =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_noor", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.NOOR, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_noor"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_STEVE =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_steve", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.STEVE, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_steve"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_SUNNY =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_sunny", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.SUNNY, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_sunny"));
  public static final RegistryObject<EntityType<ReceptionistEntity>> RECEPTIONIST_ZURI =
      ENTITY_TYPES.register(ReceptionistEntity.ID + "_zuri", () -> EntityType.Builder
          .<ReceptionistEntity>of((EntityType<ReceptionistEntity> entityType, Level level) -> {
            return new ReceptionistEntity(entityType, ReceptionistVariant.ZURI, level);
          }, ApartmentNPCEntityData.CATEGORY).sized(1.0F, 2.0F).clientTrackingRange(8)
          .build(ReceptionistEntity.ID + "_zuri"));

  @SubscribeEvent
  public static final void entityAttributeCreation(EntityAttributeCreationEvent event) {
    // Receptionist NPC Entity
    event.put(RECEPTIONIST.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_ALEX.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_ARI.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_EFE.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_KAI.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_MAKENA.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_NOOR.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_STEVE.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_SUNNY.get(), ReceptionistEntity.createAttributes().build());
    event.put(RECEPTIONIST_ZURI.get(), ReceptionistEntity.createAttributes().build());
  }

}
