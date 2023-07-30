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

import java.util.UUID;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;

import net.minecraftforge.network.NetworkEvent;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.config.CommonConfig;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;
import de.markusbordihn.mypersonalapartment.teleporter.TeleporterManager;

public class MessageTeleportToApartment {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Config values
  protected static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  protected final UUID apartmentId;

  public MessageTeleportToApartment(UUID apartmentID) {
    this.apartmentId = apartmentID;
  }

  public UUID getApartmentId() {
    return this.apartmentId;
  }

  public static void handle(MessageTeleportToApartment message,
      Supplier<NetworkEvent.Context> contextSupplier) {
    NetworkEvent.Context context = contextSupplier.get();
    context.enqueueWork(() -> handlePacket(message, context));
    context.setPacketHandled(true);
  }

  public static void handlePacket(MessageTeleportToApartment message,
      NetworkEvent.Context context) {
    // Verify server player.
    ServerPlayer serverPlayer = context.getSender();
    if (serverPlayer == null) {
      return;
    }

    // Verify apartment id.
    UUID apartmentId = message.apartmentId;
    if (apartmentId == null) {
      log.error("Invalid apartment id {} for player {}!", apartmentId,
          serverPlayer.getName().getString());
      return;
    }

    // Get Apartment Data
    ApartmentsData apartmentsData = ApartmentsData.get();

    // Verify that player has access to apartment.
    ApartmentData apartmentData = apartmentsData.getApartmentData(serverPlayer, apartmentId);
    if (apartmentData == null) {
      log.error("Player {} has no access to apartment {}!", serverPlayer.getName().getString(),
          apartmentId);
      return;
    }

    // Verify that a valid spawn position is available.
    BlockPos spawnPosition = apartmentData.getSpawnBlockPos();
    if (spawnPosition == null || spawnPosition.equals(BlockPos.ZERO)) {
      log.error("No valid spawn position found for apartment {}!", apartmentId);
      return;
    }

    log.info("Teleport player {} to apartment {} at {}.",
        serverPlayer.getName().getString(), apartmentId, spawnPosition);
    TeleporterManager.teleportToApartmentDimension(serverPlayer, spawnPosition);
  }

}
