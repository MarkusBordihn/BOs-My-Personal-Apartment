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

package de.markusbordihn.mypersonalapartment.data;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.server.ServerLifecycleHooks;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;

@EventBusSubscriber
public class ApartmentData extends SavedData {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  private static final String FILE_ID = Constants.MOD_ID;
  private static MinecraftServer server = null;
  private static ApartmentData data = null;
  private static ServerLevel level = null;

  private boolean dimensionLoaded = false;
  private long lastUpdate;

  public ApartmentData() {
    this.setDirty();
  }

  @SubscribeEvent
  public static void handleServerAboutToStartEvent(ServerAboutToStartEvent event) {
    // Reset data and server for the integrated server.
    data = null;
    level = null;
    server = null;
  }

  public static ApartmentData get() {
    if (ApartmentData.data == null || ApartmentData.level == null) {
      prepare(ServerLifecycleHooks.getCurrentServer());
    }
    return ApartmentData.data;
  }

  public static void prepare(MinecraftServer server) {
    // Make sure we preparing the data only once for the same server!
    if (server == ApartmentData.server && ApartmentData.data != null && ApartmentData.level != null) {
      return;
    }

    ApartmentData.server = server;
    ApartmentData.level = DimensionManager.getApartmentDimension();
    if (ApartmentData.level != null) {
      log.info("{} preparing data for {} and {}", Constants.LOG_NAME, ApartmentData.server,
          ApartmentData.level);
      ApartmentData.data = ApartmentData.level.getDataStorage().computeIfAbsent(ApartmentData::load, ApartmentData::new,
          ApartmentData.getFileId());
    } else {
      log.error("Unable to preparing data for {} and {}", ApartmentData.server, ApartmentData.level);
    }
  }

  public static String getFileId() {
    return FILE_ID;
  }

  public long getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(long lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public boolean getDimensionLoaded() {
    return this.dimensionLoaded;
  }

  public void setDimensionLoaded(boolean loaded) {
    this.dimensionLoaded = loaded;
  }

  public static ApartmentData load(CompoundTag compoundTag) {
    ApartmentData apartmentData = new ApartmentData();
    log.info("{} loading void dimension data ... {}", Constants.LOG_NAME, compoundTag);
    apartmentData.dimensionLoaded = compoundTag.getBoolean("DimensionLoaded");
    apartmentData.lastUpdate = compoundTag.getLong("LastUpdate");
    return apartmentData;
  }

  @Override
  public CompoundTag save(CompoundTag compoundTag) {
    log.info("{} saving void dimension data ... {}", Constants.LOG_NAME, this);
    compoundTag.putBoolean("DimensionLoaded", this.dimensionLoaded);
    compoundTag.putLong("LastUpdate", new Date().getTime());
    return compoundTag;
  }

}
