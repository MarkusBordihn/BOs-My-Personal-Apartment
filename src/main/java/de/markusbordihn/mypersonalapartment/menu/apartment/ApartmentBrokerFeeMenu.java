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

package de.markusbordihn.mypersonalapartment.menu.apartment;

import javax.annotation.Nullable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.menu.ModMenuTypes;

public class ApartmentBrokerFeeMenu extends ApartmentMenu {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  public ApartmentBrokerFeeMenu(int windowId, Inventory playerInventory) {
    super(ModMenuTypes.APARTMENT_BROKER_FEE_MENU.get(), windowId, playerInventory);
  }

  public ApartmentBrokerFeeMenu(int windowId, Inventory playerInventory, FriendlyByteBuf data) {
    this(windowId, playerInventory);
  }

  public int getApartmentBrokerFee() {
    return COMMON.apartmentBrokerFee.get();
  }

  public static MenuProvider getMenuProvider(Player player) {
    return new MenuProvider() {
      @Override
      public Component getDisplayName() {
        return Component
            .literal("🏢 Apartment Broker Fee Dialog for " + player.getName().getString());
      }

      @Nullable
      @Override
      public AbstractContainerMenu createMenu(int windowId, Inventory inventory,
          Player serverPlayer) {
        return new ApartmentBrokerFeeMenu(windowId, inventory);
      }
    };
  }

}
