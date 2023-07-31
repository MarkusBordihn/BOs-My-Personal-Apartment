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

package de.markusbordihn.mypersonalapartment.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;
import de.markusbordihn.mypersonalapartment.teleporter.TeleporterManager;

public class BackCommand extends CustomCommand {

  public static ArgumentBuilder<CommandSourceStack, ?> register() {
    return Commands.literal("back")
        .requires(commandSourceStack -> commandSourceStack.hasPermission(0)).executes(context -> {
          return run(context.getSource());
        });
  }

  private static int run(CommandSourceStack context) throws CommandSyntaxException {
    ServerPlayer serverPlayer = context.getPlayerOrException();

    // Check if the player is in the apartment dimension.
    if (!DimensionManager.isApartmentDimension(serverPlayer.level())) {
      context.sendFailure(Component
          .translatable(Constants.TEXT_COMMAND_PREFIX + "back.error.not_in_apartment_dimension"));
      return 0;
    }

    // Check if the player has a apartment with a spawn point.
    if (!ApartmentsData.get().hasApartment(serverPlayer)) {
      context.sendFailure(
          Component.translatable(Constants.TEXT_COMMAND_PREFIX + "back.error.no_apartment"));
      return 0;
    }

    // Teleport player to the last known spawn point.
    if (TeleporterManager.teleportBackToLastDimension(serverPlayer)) {
      context.sendSuccess(
          () -> Component.translatable(Constants.TEXT_COMMAND_PREFIX + "back.success"), false);
      return Command.SINGLE_SUCCESS;
    } else {
      context.sendFailure(
          Component.translatable(Constants.TEXT_COMMAND_PREFIX + "back.error.no_last_dimension"));
    }
    return 0;
  }

}
