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

package de.markusbordihn.mypersonalapartment.entity.npc.receptionist;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import net.minecraftforge.network.NetworkHooks;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;
import de.markusbordihn.mypersonalapartment.entity.ApartmentNPCEntity;
import de.markusbordihn.mypersonalapartment.menu.apartment.ApartmentBrokerFeeMenu;
import de.markusbordihn.mypersonalapartment.menu.apartment.ClaimApartmentMenu;
import de.markusbordihn.mypersonalapartment.menu.apartment.TeleportApartmentMenu;

public class ReceptionistEntity extends ApartmentNPCEntity {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // General Information
  public static final String ID = "receptionist";
  public static final String NAME = "Receptionist";
  private ReceptionistVariant variant = ReceptionistVariant.ALEX;

  public ReceptionistEntity(EntityType<? extends Mob> entityType, Level level) {
    super(entityType, level);
    this.setCustomName(Component.translatable(Constants.ENTITY_PREFIX + ID));
    this.setItemInHand(InteractionHand.MAIN_HAND, Items.PAPER.getDefaultInstance());
  }

  public ReceptionistEntity(EntityType<? extends Mob> entityType, ReceptionistVariant variant,
      Level level) {
    this(entityType, level);
    this.setVariant(variant);
  }

  public static AttributeSupplier.Builder createAttributes() {
    return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0)
        .add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.ATTACK_DAMAGE, 0);
  }

  public static void openApartmentBrokerFeeDialog(ServerPlayer serverPlayer) {
    NetworkHooks.openScreen(serverPlayer, ApartmentBrokerFeeMenu.getMenuProvider(serverPlayer),
        buffer -> buffer.writeUUID(serverPlayer.getUUID()));
  }

  public static void openClaimApartmentDialog(ServerPlayer serverPlayer) {
    NetworkHooks.openScreen(serverPlayer, ClaimApartmentMenu.getMenuProvider(serverPlayer),
        buffer -> buffer.writeUUID(serverPlayer.getUUID()));
  }

  public static void openTeleportApartmentDialog(ServerPlayer serverPlayer) {
    NetworkHooks.openScreen(serverPlayer, TeleportApartmentMenu.getMenuProvider(serverPlayer),
        buffer -> ApartmentsData.get().writeApartmentsToBuffer(serverPlayer, buffer));
  }

  public ReceptionistVariant getVariant() {
    return this.variant;
  }

  public void setVariant(ReceptionistVariant variant) {
    this.variant = variant;
  }

  @Override
  public InteractionResult mobInteract(Player player, InteractionHand hand) {
    if (player instanceof ServerPlayer serverPlayer && hand == InteractionHand.MAIN_HAND) {
      log.info("{} interact with {} ...", serverPlayer, this.getCustomName());

      // Get Apartment Data
      ApartmentsData apartmentsData = ApartmentsData.get();

      // Check if player has already an apartment and show broker fee dialog, if needed.
      if (!apartmentsData.hasApartmentData(serverPlayer) && COMMON.apartmentBrokerFee.get() > 0) {
        log.info("Open apartment broker fee dialog for {} ...", serverPlayer);
        openApartmentBrokerFeeDialog(serverPlayer);
        return InteractionResult.PASS;
      }

      // Show claim apartment dialog, if player has no apartment yet or if player has less than the
      // maximum number of apartments.
      if (apartmentsData.hasApartmentData(serverPlayer) && apartmentsData
          .getNumberOfApartments(serverPlayer) < COMMON.apartmentMaxNumberOfApartments.get()) {
        log.info("Open claim apartment dialog for {} with {} apartments of {} possible.",
            serverPlayer, apartmentsData.getNumberOfApartments(serverPlayer),
            COMMON.apartmentMaxNumberOfApartments.get());
        openClaimApartmentDialog(serverPlayer);
        return InteractionResult.PASS;
      }

      // Show teleport apartment dialog, if player has already an apartment.
      if (apartmentsData.hasApartmentData(serverPlayer)
          && apartmentsData.getNumberOfApartments(serverPlayer) > 0) {
        Set<ApartmentData> apartmentData = ApartmentsData.get().getApartmentData(serverPlayer);
        log.info("{} already has an apartment {} ...", serverPlayer, apartmentData);
        for (ApartmentData data : apartmentData) {
          log.info("Apartment {} is located at {}:{} with spawn point {}", data.getApartmentUUID(),
              data.getStartBlockPos(), data.getEndBlockPos(), data.getSpawnBlockPos());
        }
        openTeleportApartmentDialog(serverPlayer);
        return InteractionResult.PASS;
      }

      return super.mobInteract(player, hand);
    }

    return InteractionResult.PASS;
  }

}
