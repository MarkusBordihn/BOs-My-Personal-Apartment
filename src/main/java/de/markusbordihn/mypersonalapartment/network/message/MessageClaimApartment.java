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

package de.markusbordihn.mypersonalapartment.network.message;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Items;

import net.minecraftforge.network.NetworkEvent;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.config.CommonConfig;
import de.markusbordihn.mypersonalapartment.data.ApartmentBaseGrid;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;

public class MessageClaimApartment {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Config values
  protected static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  protected final int tier;
  protected final String apartmentId;

  public MessageClaimApartment(int tier, String apartmentID) {
    this.tier = tier;
    this.apartmentId = apartmentID;
  }

  public int getTier() {
    return this.tier;
  }

  public String getApartmentId() {
    return this.apartmentId;
  }

  public static void handle(MessageClaimApartment message,
      Supplier<NetworkEvent.Context> contextSupplier) {
    NetworkEvent.Context context = contextSupplier.get();
    context.enqueueWork(() -> handlePacket(message, context));
    context.setPacketHandled(true);
  }

  public static void handlePacket(MessageClaimApartment message, NetworkEvent.Context context) {
    // Verify server player.
    ServerPlayer serverPlayer = context.getSender();
    if (serverPlayer == null) {
      return;
    }

    // Verify apartment tier.
    int tier = message.tier;
    if (tier < 1 || tier > 3) {
      log.error("Invalid apartment tier {} for player {}!", message.tier,
          serverPlayer.getName().getString());
      return;
    }

    // Verify apartment id.
    String apartmentId = message.apartmentId;
    if (apartmentId == null || apartmentId.isEmpty()) {
      log.error("Invalid apartment id {} for player {}!", apartmentId,
          serverPlayer.getName().getString());
      return;
    }
    if (!apartmentId.contains("/tier" + tier + "/")) {
      log.error("Invalid tier {} for apartment id {} for player {}!", tier, apartmentId,
          serverPlayer.getName().getString());
      return;
    }

    // Get Apartment Data
    ApartmentsData apartmentsData = ApartmentsData.get();

    // Verify that player has payed the broker fee, if needed.
    if (COMMON.apartmentBrokerFee.get() > 0 && !apartmentsData.hasApartmentData(serverPlayer)) {
      log.error("Player {} has not payed the broker fee of {} {} yet!",
          serverPlayer.getName().getString(), COMMON.apartmentBrokerFee.get(), Items.EMERALD);
      return;
    }

    // Verify that player has not already to many apartments.
    if (apartmentsData.hasMaxApartments(serverPlayer)) {
      log.error("Player {} has already reached the maximum number of apartments!",
          serverPlayer.getName().getString());
      return;
    }

    // Check if we have a free apartment grid.
    BlockPos[] apartmentGrid = ApartmentBaseGrid.getNextSmallGrid();
    if (apartmentGrid == null || apartmentGrid.length < 2) {
      log.error("No free apartment grid found for {} ...", serverPlayer);
      return;
    }

    // Generate new apartment.
    BlockPos apartmentStartPos = apartmentGrid[0];
    BlockPos apartmentEndPos = apartmentGrid[1];
    log.info("Found free apartment grid for {} at {}:{} ...", serverPlayer, apartmentStartPos,
        apartmentEndPos);
    ApartmentBaseGrid.createApartment(apartmentStartPos, apartmentEndPos, apartmentId);

    // Store apartment data for apartment and player.
    ApartmentData apartmentData =
        new ApartmentData(serverPlayer, apartmentStartPos, apartmentEndPos);
    apartmentData.setTier(tier);
    apartmentData.setApartmentType(apartmentId);
    apartmentsData.addApartmentData(serverPlayer, apartmentData);
    log.info("Stored new apartment data for {} with {}", serverPlayer, apartmentData);
  }

}
