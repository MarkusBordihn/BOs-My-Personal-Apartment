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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.commands.CommandManager;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;

@EventBusSubscriber
public class ApartmentBaseGrid {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ApartmentBaseGrid() {}

  // Grid start and end position
  public static final int GRID_START_X = 0;
  public static final int GRID_START_Y = 31;
  public static final int GRID_START_Z = 0;

  public static final int GRID_END_X = 495;
  public static final int GRID_END_Y = 47;
  public static final int GRID_END_Z = 495;

  // Grid size
  public static final int GRID_SMALL_SIZE = 16;
  public static final int GRID_MEDIUM_SIZE = 32;

  // Grid padding
  public static final int GRID_SMALL_PADDING_X = 32;
  public static final int GRID_SMALL_PADDING_Y = 32;

  public static final int GRID_MEDIUM_PADDING_X = 16;
  public static final int GRID_MEDIUM_PADDING_Y = 16;

  // Cache
  private static boolean hasFreeSmallGrid = true;

  @SubscribeEvent
  public static void handleServerAboutToStartEvent(ServerAboutToStartEvent event) {
    // Reset data and server for the integrated server.
    hasFreeSmallGrid = true;
  }

  public static BlockPos[] getNextSmallGrid() {
    ServerLevel serverLevel = DimensionManager.getApartmentDimension();
    if (serverLevel == null) {
      log.warn("Unable to get apartment dimension to find next small grid!");
      return new BlockPos[] {};
    }

    if (!hasFreeSmallGrid) {
      log.warn("No free small grid available!");
      return new BlockPos[] {};
    }

    for (int z = GRID_START_Z; z < GRID_END_Z; z += GRID_SMALL_SIZE + GRID_SMALL_PADDING_Y) {
      for (int x = GRID_START_X; x < GRID_END_X; x += GRID_SMALL_SIZE + GRID_SMALL_PADDING_X) {
        BlockPos blockPosStart = new BlockPos(x, GRID_START_Y, z);
        BlockPos blockPosEnd =
            new BlockPos(x + GRID_SMALL_SIZE - 1, GRID_END_Y, z + GRID_SMALL_SIZE - 1);

        // Force chunk to be loaded before check.
        serverLevel.setChunkForced(x, z, true);

        // Check Block State
        BlockState blockStateStart = serverLevel.getBlockState(blockPosStart);
        BlockState blockStateEnd = serverLevel.getBlockState(blockPosEnd);
        if (blockStateStart.isAir() && blockStateEnd.isAir()) {
          if (blockPosStart.getX() >= GRID_START_X && blockPosStart.getY() >= GRID_START_Y
              && blockPosStart.getZ() >= GRID_START_Z && blockPosEnd.getX() <= GRID_END_X
              && blockPosEnd.getY() <= GRID_END_Y && blockPosEnd.getZ() <= GRID_END_Z) {
            log.info("Found free small grid at {} {}", blockPosStart, blockPosEnd);
            serverLevel.setChunkForced(x, z, false);
            return new BlockPos[] {blockPosStart, blockPosEnd};
          } else {
            log.info("Found free small grid outside allowed area at {} {}", blockPosStart,
                blockPosEnd);
          }
        } else {
          log.info("Found occupied small grid at {} {}", blockPosStart, blockPosEnd);
        }

        // Unforce chunk after check.
        serverLevel.setChunkForced(x, z, false);
      }
    }
    log.error("Unable to find free small grid in allowed area at {} {}!",
                new BlockPos(GRID_START_X, GRID_START_Y, GRID_START_Z),
                new BlockPos(GRID_END_X, GRID_END_Y, GRID_END_Z));
    hasFreeSmallGrid = false;
    return new BlockPos[] {};
  }

  public static void createApartment(BlockPos blockPosStart, BlockPos blockPosEnd,
      String structure) {
    log.info("Creating apartment at {}:{} and structure {}", blockPosStart, blockPosEnd, structure);

    BlockPos structureBlockPosition = blockPosStart.offset(0, 0, 0);
    BlockPos redstoneBlockPosition = structureBlockPosition.offset(0, 1, 0);
    log.info("Structure Block at {}", structureBlockPosition);

    ServerLevel serverLevel = DimensionManager.getApartmentDimension();
    if (serverLevel == null) {
      log.warn("Unable to get apartment dimension to create apartment {} at {}:{}!", structure,
          blockPosStart, blockPosEnd);
      return;
    }

    // Force load chunk
    CommandManager.executeServerCommand(String.format("forceload add %s %s %s %s",
        blockPosStart.getX(), blockPosStart.getZ(), blockPosEnd.getX(), blockPosEnd.getZ()),
        serverLevel);

    // Create structure block
    CommandManager.executeServerCommand(String.format(
        "setblock %s %s %s minecraft:structure_block{mode: \"LOAD\", name: \"%s\"} replace",
        structureBlockPosition.getX(), structureBlockPosition.getY(), structureBlockPosition.getZ(),
        structure), serverLevel);

    // Create redstone block to activate structure block
    CommandManager.executeServerCommand(String.format("setblock %s %s %s minecraft:redstone_block",
        redstoneBlockPosition.getX(), redstoneBlockPosition.getY(), redstoneBlockPosition.getZ()),
        serverLevel);

    // Replace structure block with bedrock to avoid glitches
    CommandManager.executeServerCommand(
        String.format("setblock %s %s %s minecraft:bedrock", structureBlockPosition.getX(),
            structureBlockPosition.getY(), structureBlockPosition.getZ()),
        serverLevel);

    // Replace redstone block with bedrock to avoid glitches
    CommandManager.executeServerCommand(String.format("setblock %s %s %s minecraft:bedrock",
        redstoneBlockPosition.getX(), redstoneBlockPosition.getY(), redstoneBlockPosition.getZ()),
        serverLevel);

    // Force unload chunk
    CommandManager.executeServerCommand(String.format("forceload remove %s %s %s %s",
        blockPosStart.getX(), blockPosStart.getZ(), blockPosEnd.getX(), blockPosEnd.getZ()),
        serverLevel);

    log.info("Apartment created at {}:{} and structure {}", blockPosStart, blockPosEnd, structure);
  }
}
