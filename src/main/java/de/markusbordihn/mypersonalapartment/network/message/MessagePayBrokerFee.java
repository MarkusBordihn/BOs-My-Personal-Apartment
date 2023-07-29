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

package de.markusbordihn.mypersonalapartment.network.message;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;
import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.config.CommonConfig;
import de.markusbordihn.mypersonalapartment.data.ApartmentsData;
import de.markusbordihn.mypersonalapartment.menu.apartment.ClaimApartmentMenu;

public class MessagePayBrokerFee {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  // Config values
  protected static final CommonConfig.Config COMMON = CommonConfig.COMMON;

  public MessagePayBrokerFee() {}

  public static void handle(MessagePayBrokerFee message,
      Supplier<NetworkEvent.Context> contextSupplier) {
    NetworkEvent.Context context = contextSupplier.get();
    context.enqueueWork(() -> handlePacket(message, context));
    context.setPacketHandled(true);
  }

  public static void handlePacket(MessagePayBrokerFee message, NetworkEvent.Context context) {
    ServerPlayer serverPlayer = context.getSender();

    if (serverPlayer == null) {
      return;
    }

    // Verify if player is able to pay the broker fee.
    int brokerFee = COMMON.apartmentBrokerFee.get();
    if (brokerFee > 0 && serverPlayer.getInventory().countItem(Items.EMERALD) < brokerFee) {
      log.error("Player {} is not able to pay the broker fee of {}.", serverPlayer, brokerFee);
      return;
    }

    // Pay broker fee, from different slots if necessary.
    if (brokerFee > 0) {
      Inventory inventory = serverPlayer.getInventory();
      int removedBrokerFeeItems = 0;
      for (int i = 0; i < inventory.getContainerSize(); i++) {
        if (inventory.getItem(i).getItem() == Items.EMERALD && removedBrokerFeeItems < brokerFee) {
          if (inventory.getItem(i).getCount() >= brokerFee - removedBrokerFeeItems) {
            inventory.getItem(i).shrink(brokerFee);
            removedBrokerFeeItems += brokerFee;
            break;
          } else {
            removedBrokerFeeItems += inventory.getItem(i).getCount();
            inventory.setItem(i, Items.AIR.getDefaultInstance());
          }
        }
      }

      // Update inventory and send changes to client.
      serverPlayer.containerMenu.broadcastChanges();
      serverPlayer.inventoryMenu.broadcastFullState();
    }

    // Pay broker fee and set apartment to rented.
    if (brokerFee > 0) {
      serverPlayer.displayClientMessage(
          Component.nullToEmpty("You paid the broker fee of " + brokerFee + " emeralds."), true);
    }

    // Create apartment entry to database.
    ApartmentsData.get().addEmptyApartmentData(serverPlayer);

    // Open apartment claim menu.
    NetworkHooks.openScreen(serverPlayer, ClaimApartmentMenu.getMenuProvider(serverPlayer),
        buffer -> buffer.writeUUID(serverPlayer.getUUID()));
  }

}
