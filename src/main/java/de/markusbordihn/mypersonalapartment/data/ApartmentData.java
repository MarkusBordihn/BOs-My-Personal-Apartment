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

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import de.markusbordihn.mypersonalapartment.Constants;

public class ApartmentData {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Compound Tags
  private static final String APARTMENT_UUID_TAG = "UUID";
  private static final String OWNER_UUID_TAG = "OwnerUUID";
  private static final String START_BLOCK_POS_TAG = "StartBlockPos";
  private static final String END_BLOCK_POS_TAG = "EndBlockPos";
  private static final String SPAWN_BLOCK_POS_TAG = "SpawnBlockPos";
  private static final String APARTMENT_NAME_TAG = "ApartmentName";
  private static final String TIER_TAG = "Tier";
  private static final String APARTMENT_TYPE_TAG = "ApartmentType";

  // Data Holder
  private UUID ownerUUID;
  private UUID apartmentUUID = UUID.randomUUID();
  private BlockPos startBlockPos;
  private BlockPos endBlockPos;
  private BlockPos spawnBlockPos;
  private String apartmentName;
  private int tier;
  private String apartmentType;

  public ApartmentData(ServerPlayer serverPlayer, BlockPos startBlockPos, BlockPos endBlockPos) {
    this(serverPlayer, startBlockPos, endBlockPos, startBlockPos.offset(4, 6, 4));
  }

  public ApartmentData(ServerPlayer serverPlayer, BlockPos startBlockPos, BlockPos endBlockPos,
      BlockPos spawnBlockPos) {
    this.ownerUUID = serverPlayer.getUUID();
    this.startBlockPos = startBlockPos;
    this.endBlockPos = endBlockPos;
    this.spawnBlockPos = spawnBlockPos;
    this.apartmentName =
        serverPlayer.getName().getString() + "'s Apartment (" + this.apartmentUUID + ")";
  }

  public ApartmentData(FriendlyByteBuf buffer) {
    this.readFromBuffer(buffer);
  }

  public ApartmentData(CompoundTag compoundTag) {
    this.load(compoundTag);
  }

  public UUID getApartmentUUID() {
    return this.apartmentUUID;
  }

  public void setApartmentUUID(UUID uuid) {
    this.apartmentUUID = uuid;
  }

  public UUID getOwnerUUID() {
    return this.ownerUUID;
  }

  public void setUUID(UUID uuid) {
    this.ownerUUID = uuid;
  }

  public BlockPos getStartBlockPos() {
    return this.startBlockPos;
  }

  public void setStartBlockPos(BlockPos blockPos) {
    this.startBlockPos = blockPos;
  }

  public BlockPos getEndBlockPos() {
    return this.endBlockPos;
  }

  public void setEndBlockPos(BlockPos blockPos) {
    this.endBlockPos = blockPos;
  }

  public BlockPos getSpawnBlockPos() {
    return this.spawnBlockPos;
  }

  public void setSpawnBlockPos(BlockPos blockPos) {
    this.spawnBlockPos = blockPos;
  }

  public String getApartmentName() {
    return this.apartmentName;
  }

  public void setApartmentName(String apartmentName) {
    this.apartmentName = apartmentName;
  }

  public int getTier() {
    return this.tier;
  }

  public void setTier(int tier) {
    this.tier = tier;
  }

  public String getApartmentType() {
    return this.apartmentType;
  }

  public void setApartmentType(String apartmentType) {
    this.apartmentType = apartmentType;
  }

  public void load(CompoundTag compoundTag) {
    log.info("Loading apartment data from {}", compoundTag);
    this.apartmentUUID =
        compoundTag.contains(APARTMENT_UUID_TAG) ? compoundTag.getUUID(APARTMENT_UUID_TAG)
            : UUID.randomUUID();
    this.ownerUUID = compoundTag.getUUID(OWNER_UUID_TAG);
    this.startBlockPos = NbtUtils.readBlockPos(compoundTag.getCompound(START_BLOCK_POS_TAG));
    this.endBlockPos = NbtUtils.readBlockPos(compoundTag.getCompound(END_BLOCK_POS_TAG));
    this.spawnBlockPos = NbtUtils.readBlockPos(compoundTag.getCompound(SPAWN_BLOCK_POS_TAG));
    this.apartmentName = compoundTag.getString(APARTMENT_NAME_TAG);
    this.tier = compoundTag.getInt(TIER_TAG);
    this.apartmentType = compoundTag.getString(APARTMENT_TYPE_TAG);
  }

  public CompoundTag save(CompoundTag compoundTag) {
    log.info("Saving apartment data to {}", compoundTag);
    compoundTag.putUUID(APARTMENT_UUID_TAG, this.apartmentUUID);
    compoundTag.putUUID(OWNER_UUID_TAG, this.ownerUUID);
    compoundTag.put(START_BLOCK_POS_TAG, NbtUtils.writeBlockPos(this.startBlockPos));
    compoundTag.put(END_BLOCK_POS_TAG, NbtUtils.writeBlockPos(this.endBlockPos));
    compoundTag.put(SPAWN_BLOCK_POS_TAG, NbtUtils.writeBlockPos(this.spawnBlockPos));
    compoundTag.putString(APARTMENT_NAME_TAG, this.apartmentName);
    compoundTag.putInt(TIER_TAG, this.tier);
    compoundTag.putString(APARTMENT_TYPE_TAG, this.apartmentType);
    return compoundTag;
  }

  public void writeToBuffer(FriendlyByteBuf buffer) {
    buffer.writeUUID(this.apartmentUUID);
    buffer.writeUUID(this.ownerUUID);
    buffer.writeBlockPos(this.startBlockPos);
    buffer.writeBlockPos(this.endBlockPos);
    buffer.writeBlockPos(this.spawnBlockPos);
    buffer.writeUtf(this.apartmentName);
    buffer.writeInt(this.tier);
    buffer.writeUtf(this.apartmentType);
  }

  public void readFromBuffer(FriendlyByteBuf buffer) {
    this.apartmentUUID = buffer.readUUID();
    this.ownerUUID = buffer.readUUID();
    this.startBlockPos = buffer.readBlockPos();
    this.endBlockPos = buffer.readBlockPos();
    this.spawnBlockPos = buffer.readBlockPos();
    this.apartmentName = buffer.readUtf();
    this.tier = buffer.readInt();
    this.apartmentType = buffer.readUtf();
  }

}
