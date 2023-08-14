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

package de.markusbordihn.mypersonalapartment.block;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;

public class KeyHolderBlock extends Block {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

  protected static final VoxelShape SHAPE_NORTH_AABB = Block.box(0, 0, 13, 16, 16, 16);
  protected static final VoxelShape SHAPE_EAST_AABB = Block.box(0, 0, 0, 3, 16, 16);
  protected static final VoxelShape SHAPE_SOUTH_AABB = Block.box(0, 0, 0, 16, 16, 3);
  protected static final VoxelShape SHAPE_WEST_AABB = Block.box(13, 0, 0, 16, 16, 16);

  public KeyHolderBlock() {
    this(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_PLANKS));
  }

  public KeyHolderBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  @SuppressWarnings("java:S1874")
  public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
      InteractionHand hand, BlockHitResult hitResult) {
    if (level.isClientSide) {
      return InteractionResult.SUCCESS;
    }

    log.info("KeyHolderBlock.use by {}", player.getName().getString());
    if (player instanceof ServerPlayer serverPlayer) {
      ApartmentsData apartmentsData = ApartmentsData.get();
      if (apartmentsData.hasApartment(serverPlayer)) {
        MutableComponent message =
            Component.translatable(Constants.MESSAGE_PREFIX + "apartment_key")
                .withStyle(ChatFormatting.YELLOW);
        player.sendSystemMessage(message);
        return InteractionResult.CONSUME;
      } else {
        MutableComponent message = Component.translatable(Constants.MESSAGE_PREFIX + "no_apartment")
            .withStyle(ChatFormatting.YELLOW);
        player.sendSystemMessage(message);
        return InteractionResult.CONSUME;
      }
    }

    return InteractionResult.PASS;
  }

  /** @deprecated */
  @Deprecated
  @Override
  public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
      CollisionContext collisionContext) {
    switch (blockState.getValue(FACING)) {
      case NORTH:
        return SHAPE_NORTH_AABB;
      case EAST:
        return SHAPE_EAST_AABB;
      case SOUTH:
        return SHAPE_SOUTH_AABB;
      case WEST:
        return SHAPE_WEST_AABB;
      default:
        return SHAPE_NORTH_AABB;
    }
  }

  @Override
  @Nullable
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING,
        context.getHorizontalDirection().getOpposite());
  }

  /** @deprecated */
  @Deprecated
  @Override
  public BlockState rotate(BlockState blockState, Rotation rotation) {
    return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
  }

  /** @deprecated */
  @Deprecated
  @Override
  public BlockState mirror(BlockState blockState, Mirror mirror) {
    return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockState) {
    blockState.add(FACING);
  }

}
