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
import net.minecraft.world.level.Level;

import net.minecraftforge.network.NetworkHooks;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;
import de.markusbordihn.mypersonalapartment.entity.ApartmentNPCEntity;
import de.markusbordihn.mypersonalapartment.menu.apartment.ApartmentBrokerFeeMenu;
import de.markusbordihn.mypersonalapartment.menu.apartment.ClaimApartmentMenu;

public class Reception extends ApartmentNPCEntity {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // General Information
  public static final String ID = "reception";
  public static final String NAME = "Reception";

  public Reception(EntityType<? extends Mob> entityType, Level level) {
    super(entityType, level);
    this.setCustomName(Component.translatable(Constants.TEXT_PREFIX + ID));
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
    log.info("Open teleport apartment dialog for {} ...", serverPlayer);
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

      if (apartmentsData.hasApartmentData(serverPlayer) && apartmentsData
          .getNumberOfApartments(serverPlayer) < COMMON.apartmentMaxNumberOfApartments.get()) {
        log.info("Open claim apartment dialog for {} with {} apartments of {} possible.",
            serverPlayer, apartmentsData.getNumberOfApartments(serverPlayer),
            COMMON.apartmentMaxNumberOfApartments.get());
        openClaimApartmentDialog(serverPlayer);
        return InteractionResult.PASS;
      }


      if (apartmentsData.hasApartmentData(serverPlayer) && apartmentsData
          .getNumberOfApartments(serverPlayer) > 0) {
        Set<ApartmentData> apartmentData = ApartmentsData.get().getApartmentData(serverPlayer);
        log.info("{} already has an apartment {} ...", serverPlayer, apartmentData);
        for (ApartmentData data : apartmentData) {
          log.info("Apartment {} is located at {}:{} ...", data.getApartmentUUID(),
              data.getStartBlockPos(), data.getEndBlockPos());
        }
        return InteractionResult.PASS;
      }

      /**
      else {
        log.info("{} has no apartment yet ...", serverPlayer);
        BlockPos[] apartmentGrid = ApartmentBaseGrid.getNextSmallGrid();
        if (apartmentGrid == null || apartmentGrid.length < 2) {
          log.info("No free apartment grid found for {} ...", serverPlayer);
          return InteractionResult.PASS;
        }

        // Generate new apartment
        BlockPos apartmentStartPos = apartmentGrid[0];
        BlockPos apartmentEndPos = apartmentGrid[1];
        log.info("Found free apartment grid for {} at {}:{} ...", serverPlayer, apartmentStartPos,
            apartmentEndPos);
        ApartmentBaseGrid.createApartment(apartmentStartPos, apartmentEndPos,
            "my_personal_apartment:apartment/16x16/16x16_apartment_empty");

        // Store apartment data
        ApartmentData apartmentData =
            new ApartmentData(serverPlayer, apartmentStartPos, apartmentEndPos);
        ApartmentsData.get().addApartmentData(serverPlayer, apartmentData);
        log.info("Stored new apartment data for {}: {}", serverPlayer, apartmentData);
      }
      */

      return super.mobInteract(player, hand);
    }

    return InteractionResult.PASS;
  }

}
