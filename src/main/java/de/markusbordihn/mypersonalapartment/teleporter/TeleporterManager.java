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

package de.markusbordihn.mypersonalapartment.teleporter;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;

@EventBusSubscriber
public class TeleporterManager {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);


  private static HashMap<ServerPlayer, ResourceKey<Level>> teleportHistoryDimensionMap =
      new HashMap<>();
  private static HashMap<ServerPlayer, BlockPos> teleportHistoryPositionMap = new HashMap<>();

  private static Component backCommand;

  protected TeleporterManager() {}

  @SubscribeEvent
  public static void handleServerAboutToStartEvent(ServerAboutToStartEvent event) {
    // Clear teleport history on server start to avoid side effects.
    teleportHistoryDimensionMap = new HashMap<>();
    teleportHistoryPositionMap = new HashMap<>();

    // Clickable commands
    backCommand = Component.literal("/my_personal_apartment back")
        .setStyle(Style.EMPTY.withColor(ChatFormatting.GREEN).withClickEvent(
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/my_personal_apartment back")));
  }

  public static boolean teleportToApartmentDimension(ServerPlayer player, BlockPos spawnPosition) {
    ServerLevel apartmentDimension = DimensionManager.getApartmentDimension();
    boolean isSameDimension = player.level() == apartmentDimension;
    boolean successfullyTeleported = teleportPlayer(player, apartmentDimension, spawnPosition);
    if (successfullyTeleported && !isSameDimension) {
      player.sendSystemMessage(
          Component.translatable(Constants.TEXT_PREFIX + "welcome_to_apartment", backCommand));
    }
    return successfullyTeleported;
  }

  public static boolean teleportBackToLastDimension(ServerPlayer player) {
    ResourceKey<Level> lastDimension = teleportHistoryDimensionMap.get(player);
    BlockPos lastPosition = teleportHistoryPositionMap.get(player);
    if (lastDimension == null || lastPosition == null) {
      ServerLevel respawnLevel = player.server.getLevel(player.getRespawnDimension());
      BlockPos respawnPosition = player.getRespawnPosition();
      log.warn("Unable to find last dimension for player {}, will use respawn dimension {} with {}",
          player, respawnLevel, respawnPosition);
      return teleportPlayer(player, respawnLevel, respawnPosition);
    }
    return teleportPlayer(player, player.server.getLevel(lastDimension), lastPosition);
  }

  private static boolean teleportPlayer(ServerPlayer player, ServerLevel dimension,
      BlockPos spawnPosition) {
    // Ignore client side levels and if dimension was not found.
    if (player.level().isClientSide() || dimension == null) {
      return false;
    }

    // Use spawn position if available.
    if (spawnPosition != null) {
      return teleportPlayer(player, dimension, spawnPosition.getX(), spawnPosition.getY(),
          spawnPosition.getZ());
    }

    // Use shared spawn position as fallback.
    BlockPos sharedSpawnPos = dimension.getSharedSpawnPos();
    return teleportPlayer(player, dimension, sharedSpawnPos.getX(), sharedSpawnPos.getY(),
        sharedSpawnPos.getZ());
  }

  private static boolean teleportPlayer(ServerPlayer player, ServerLevel dimension, int x, int y,
      int z) {
    // Ignore client side levels and if dimension was not found.
    if (player.level().isClientSide() || dimension == null) {
      return false;
    }

    // If we are already in the same dimension use a simple teleport instead.
    if (player.level() == dimension) {

      // Only store teleport history if we are not already in the apartment dimension.
      if (dimension.dimension() != DimensionManager.getApartmentDimension().dimension()) {
        addTeleportHistory(player);
      }

      player.teleportTo(x, y, z);
      return true;
    }

    // Use dimensional teleporter for the player.
    addTeleportHistory(player);
    player.teleportTo(dimension, x, y, z, player.getYRot(), player.getXRot());
    return true;
  }

  public static void addTeleportHistory(ServerPlayer serverPlayer) {
    Level level = serverPlayer.level();
    ResourceKey<Level> dimension = level.dimension();
    BlockPos blockPos = serverPlayer.blockPosition();
    teleportHistoryDimensionMap.put(serverPlayer, dimension);
    teleportHistoryPositionMap.put(serverPlayer, blockPos);

    log.debug("Add teleport history for player {} in {} with {}", serverPlayer, dimension,
        blockPos);
  }

}
