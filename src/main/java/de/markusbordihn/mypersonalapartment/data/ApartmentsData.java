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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.saveddata.SavedData;

import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.server.ServerLifecycleHooks;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;

@EventBusSubscriber
public class ApartmentsData extends SavedData {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Saved Data
  private static final String FILE_ID = Constants.MOD_ID;
  private static MinecraftServer server = null;
  private static ApartmentsData data = null;
  private static ServerLevel level = null;

  // Compound Tags
  private static final String APARTMENTS_TAG = "Apartments";
  private static final String DIMENSION_LOADED_TAG = "DimensionLoaded";
  private static final String LAST_UPDATE_TAG = "LastUpdate";

  // Data Holder
  private boolean dimensionLoaded = false;
  private ConcurrentHashMap<UUID, HashSet<ApartmentData>> apartmentsMap = new ConcurrentHashMap<>();
  private long lastUpdate;

  public ApartmentsData() {
    this.setDirty();
  }

  @SubscribeEvent
  public static void handleServerAboutToStartEvent(ServerAboutToStartEvent event) {
    // Reset data and server for the integrated server.
    data = null;
    level = null;
    server = null;
  }

  public static ApartmentsData get() {
    if (ApartmentsData.data == null || ApartmentsData.level == null) {
      prepare(ServerLifecycleHooks.getCurrentServer());
    }
    return ApartmentsData.data;
  }

  public static void prepare(MinecraftServer server) {
    // Make sure we preparing the data only once for the same server!
    if (server == ApartmentsData.server && ApartmentsData.data != null
        && ApartmentsData.level != null) {
      return;
    }

    ApartmentsData.server = server;
    ApartmentsData.level = DimensionManager.getApartmentDimension();
    if (ApartmentsData.level != null) {
      log.info("{} preparing data for {} and {}", Constants.LOG_NAME, ApartmentsData.server,
          ApartmentsData.level);
      ApartmentsData.data = ApartmentsData.level.getDataStorage()
          .computeIfAbsent(ApartmentsData::load, ApartmentsData::new, ApartmentsData.getFileId());
    } else {
      log.error("Unable to preparing data for {} and {}", ApartmentsData.server,
          ApartmentsData.level);
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

  public Set<ApartmentData> getApartmentData(ServerPlayer serverPlayer) {
    return this.getApartmentData(serverPlayer.getUUID());
  }

  public void addApartmentData(ServerPlayer serverPlayer, ApartmentData apartmentData) {
    this.apartmentsMap.computeIfAbsent(serverPlayer.getUUID(), k -> new HashSet<>())
        .add(apartmentData);
    this.setDirty();
  }

  public void addEmptyApartmentData(ServerPlayer serverPlayer) {
    this.apartmentsMap.computeIfAbsent(serverPlayer.getUUID(), k -> new HashSet<>());
    this.setDirty();
  }

  public Set<ApartmentData> getApartmentData(UUID uuid) {
    return this.apartmentsMap.get(uuid);
  }

  public boolean hasApartmentData(ServerPlayer serverPlayer) {
    return this.apartmentsMap.containsKey(serverPlayer.getUUID());
  }

  public boolean hasApartmentData(UUID uuid) {
    return this.apartmentsMap.containsKey(uuid);
  }

  public int getNumberOfApartments(ServerPlayer serverPlayer) {
    return this.getNumberOfApartments(serverPlayer.getUUID());
  }

  public int getNumberOfApartments(UUID uuid) {
    return this.apartmentsMap.get(uuid).size();
  }

  public static ApartmentsData load(CompoundTag compoundTag) {
    ApartmentsData apartmentData = new ApartmentsData();
    log.info("{} loading Apartments data ... {}", Constants.LOG_NAME, compoundTag);
    apartmentData.dimensionLoaded = compoundTag.getBoolean(DIMENSION_LOADED_TAG);
    apartmentData.lastUpdate = compoundTag.getLong(LAST_UPDATE_TAG);

    // Load apartments per player
    if (compoundTag.contains(APARTMENTS_TAG)) {
      CompoundTag apartmentsTag = compoundTag.getCompound(APARTMENTS_TAG);
      for (String uuid : apartmentsTag.getAllKeys()) {
        HashSet<ApartmentData> apartments = new HashSet<>();
        CompoundTag apartmentTag = apartmentsTag.getCompound(uuid);
        for (String apartmentId : apartmentTag.getAllKeys()) {
          CompoundTag apartmentDataTag = apartmentTag.getCompound(apartmentId);
          ApartmentData apartmentDataEntry = new ApartmentData(apartmentDataTag);
          apartments.add(apartmentDataEntry);
        }
        apartmentData.apartmentsMap.put(UUID.fromString(uuid), apartments);
      }
    } else {
      apartmentData.apartmentsMap = new ConcurrentHashMap<>();
    }

    return apartmentData;
  }

  @Override
  public CompoundTag save(CompoundTag compoundTag) {
    log.info("{} saving Apartments data ... {}", Constants.LOG_NAME, this);
    compoundTag.putBoolean(DIMENSION_LOADED_TAG, this.dimensionLoaded);
    compoundTag.putLong(LAST_UPDATE_TAG, new Date().getTime());

    // Save apartments per player
    if (this.apartmentsMap != null) {
      CompoundTag apartmentsTag = new CompoundTag();
      for (Map.Entry<UUID, HashSet<ApartmentData>> entry : this.apartmentsMap.entrySet()) {
        CompoundTag apartmentTag = new CompoundTag();
        for (ApartmentData apartmentData : entry.getValue()) {
          apartmentTag.put(apartmentData.getApartmentUUID().toString(),
              apartmentData.save(new CompoundTag()));
        }
        apartmentsTag.put(entry.getKey().toString(), apartmentTag);
      }
      compoundTag.put(APARTMENTS_TAG, apartmentsTag);
    }

    return compoundTag;
  }

}
