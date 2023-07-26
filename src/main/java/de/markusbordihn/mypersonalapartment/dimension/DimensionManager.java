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

package de.markusbordihn.mypersonalapartment.dimension;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.server.ServerLifecycleHooks;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.config.CommonConfig;
import de.markusbordihn.mypersonalapartment.datapack.DataPackHandler;
import de.markusbordihn.mypersonalapartment.teleporter.TeleporterManager;

@EventBusSubscriber
public class DimensionManager {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  private static Set<ServerPlayer> gameTypeReset = ConcurrentHashMap.newKeySet();
  private static Set<String> ignoredDimension = ConcurrentHashMap.newKeySet();

  private static String apartmentDimensionName = "my_personal_apartment:apartments_dimension";

  private static ServerLevel apartmentLevel = null;

  protected DimensionManager() {}

  @SubscribeEvent
  public static void handleServerAboutToStartEvent(ServerAboutToStartEvent event) {
    // Reset mapping to avoid issues.
    apartmentLevel = null;
  }

  @SubscribeEvent
  public static void handleServerStartedEvent(ServerStartedEvent event) {
    // Map dimension and init dimension structure if needed.
    mapServerLevel(event.getServer());
  }

  @SubscribeEvent
  public static void onChangeDimension(PlayerChangedDimensionEvent event) {
    Player player = event.getEntity();
    String fromLocation = event.getFrom().location().toString();
    String toLocation = event.getTo().location().toString();
    log.debug("{} Player {} changed dimension from {} to {}",
        Constants.LOG_DIMENSION_MANAGER_PREFIX, player.getName().getString(), fromLocation,
        toLocation);
  }

  private static void mapServerLevel(MinecraftServer server) {
    // Skip search if we already found all relevant dimensions.
    if (apartmentLevel != null) {
      return;
    }

    // Mapping names to server level for easier access.
    for (ServerLevel serverLevel : server.getAllLevels()) {
      String dimensionLocation = serverLevel.dimension().location().toString();
      if (dimensionLocation.equals(apartmentDimensionName)) {
        if (apartmentLevel == null) {
          log.info("{} ✔️ Found Apartment dimension with name {}: {}",
              Constants.LOG_DIMENSION_MANAGER_PREFIX, apartmentDimensionName, serverLevel);
          apartmentLevel = serverLevel;
          DataPackHandler.prepareDataPackOnce(serverLevel);
        }
      } else {
        if (ignoredDimension.isEmpty() || !ignoredDimension.contains(dimensionLocation)) {
          log.info("{} Ignore dimension {}: {}", Constants.LOG_DIMENSION_MANAGER_PREFIX,
              dimensionLocation, serverLevel);
        } else {
          ignoredDimension.add(dimensionLocation);
        }
      }
    }

    // Give error messages, if we are unable to match any dimension.
    if (apartmentLevel == null) {
      log.error("{} ⚠️ Unable to find Apartment dimension named {}!\n"
          + "If this is the first time you see this message or if you just started a new world, try to restart your server to generate them automatically!",
          Constants.LOG_DIMENSION_MANAGER_PREFIX, apartmentDimensionName);
    }
  }

  public static ServerLevel getApartmentDimension() {
    if (apartmentLevel == null) {
      mapServerLevel(ServerLifecycleHooks.getCurrentServer());
    }
    return apartmentLevel;
  }

  public static void teleportToApartment(ServerPlayer player) {
    TeleporterManager.teleportToApartmentDimension(player);
  }

}
