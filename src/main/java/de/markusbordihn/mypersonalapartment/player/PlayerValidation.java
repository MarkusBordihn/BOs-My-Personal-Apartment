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

package de.markusbordihn.mypersonalapartment.player;

import java.util.concurrent.TimeUnit;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

public class PlayerValidation {

  private ServerPlayer player;
  private String username;
  private Vec3 position;
  private double rotationYawHead;
  private long lastValidationTime = System.currentTimeMillis();

  public PlayerValidation(ServerPlayer player) {
    this.player = player;
    this.position = player.position();
    this.rotationYawHead = player.getYHeadRot();
    this.username = player.getName().getString();
  }

  public boolean hasPlayerMoved() {
    return (!this.username.equals(this.player.getName().getString())
        || !this.position.equals(this.player.position())
        || this.rotationYawHead != this.player.getYHeadRot());
  }

  public boolean hasPlayerMovedPosition() {
    return (!this.username.equals(this.player.getName().getString())
        || !this.position.equals(this.player.position()));
  }

  public ServerPlayer getPlayer() {
    return this.player;
  }

  public String getUsername() {
    return this.username;
  }

  public long getValidationTime() {
    return this.lastValidationTime;
  }

  public long getValidationTimeElapsed() {
    return System.currentTimeMillis() - this.lastValidationTime;
  }

  public long getValidationTimeSecondsElapsed() {
    return TimeUnit.MILLISECONDS.toSeconds(getValidationTimeElapsed());
  }
}
