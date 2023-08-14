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

package de.markusbordihn.mypersonalapartment.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import de.markusbordihn.mypersonalapartment.config.CommonConfig;

public class ApartmentNPCEntity extends ApartmentNPCEntityData {

  // Custom Ticker
  private static final int TRAVEL_TICK = 40;
  private int travelTicker = random.nextInt(TRAVEL_TICK / 2);

  // Config values
  protected static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  public ApartmentNPCEntity(EntityType<? extends Mob> entityType, Level level) {
    super(entityType, level);
    this.setInvulnerable(true);
  }

  @Override
  public boolean isAttackable() {
    return false;
  }

  @Override
  public boolean isPushable() {
    return false;
  }

  @Override
  public boolean removeWhenFarAway(double distance) {
    return false;
  }

  @Override
  protected void registerGoals() {
    super.registerGoals();
    this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 15.0F, 1.0F));
    this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
  }

  @Override
  public void travel(Vec3 vec3) {
    // Make sure we only calculate animations for be as much as possible client and server-friendly.
    this.calculateEntityAnimation(this instanceof FlyingAnimal);

    // Allow animation, if entity is falling or placed in air.
    if (travelTicker++ >= TRAVEL_TICK) {
      BlockState blockState = this.level().getBlockState(this.getOnPos());
      if (blockState.is(Blocks.AIR) || blockState.is(Blocks.GRASS)) {
        super.travel(vec3);
      }
      travelTicker = 0;
    }
  }

}
