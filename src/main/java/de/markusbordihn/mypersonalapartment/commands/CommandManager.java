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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.server.ServerLifecycleHooks;

import de.markusbordihn.mypersonalapartment.Constants;

@EventBusSubscriber
public class CommandManager {

  private static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected CommandManager() {}

  @SubscribeEvent
  public static void handleRegisterCommandsEvent(RegisterCommandsEvent event) {
    log.info("Registering commands for {} ...", Constants.MOD_NAME);
    CommandDispatcher<CommandSourceStack> commandDispatcher = event.getDispatcher();
    commandDispatcher.register(Commands.literal(Constants.MOD_COMMAND)
    // @formatter:off
      .then(BackCommand.register())
    // @formatter:on
    );
  }

  public static void executeServerCommand(String command) {
    MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer();
    if (minecraftServer == null) {
      return;
    }
    log.debug("Execute Server Command: /{}", command);
    Commands commands = minecraftServer.getCommands();
    CommandSourceStack commandSourceStack =
        minecraftServer.createCommandSourceStack().withSuppressedOutput();
    CommandDispatcher<CommandSourceStack> commandDispatcher = commands.getDispatcher();
    ParseResults<CommandSourceStack> parseResults =
        commandDispatcher.parse(command, commandSourceStack);
    commands.performCommand(parseResults, command);
  }

  public static void executeServerCommand(String command, ServerLevel level) {
    executeServerCommand(command, level, false);
  }

  public static void executeServerCommandDebug(String command, ServerLevel level) {
    executeServerCommand(command, level, true);
  }

  public static void executeServerCommand(String command, ServerLevel level, boolean debug) {
    MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer();
    if (minecraftServer == null) {
      return;
    }
    log.debug("Execute Server Command: {}", command);
    Commands commands = minecraftServer.getCommands();
    CommandSourceStack commandSourceStack =
        minecraftServer.createCommandSourceStack().withLevel(level);
    CommandDispatcher<CommandSourceStack> commandDispatcher = commands.getDispatcher();
    ParseResults<CommandSourceStack> parseResults = commandDispatcher.parse(command,
        debug ? commandSourceStack : commandSourceStack.withSuppressedOutput());
    commands.performCommand(parseResults, command);
  }

  public static void executeServerFunction(String functionName, ServerLevel level) {
    executeServerCommand(String.format("function %s", functionName), level);
  }

}
