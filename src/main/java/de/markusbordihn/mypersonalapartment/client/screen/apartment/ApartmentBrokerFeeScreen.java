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

package de.markusbordihn.mypersonalapartment.client.screen.apartment;

import java.util.Collections;
import java.util.List;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.menu.apartment.ApartmentBrokerFeeMenu;
import de.markusbordihn.mypersonalapartment.network.NetworkMessage;

@OnlyIn(Dist.CLIENT)
public class ApartmentBrokerFeeScreen<T extends ApartmentBrokerFeeMenu> extends ApartmentScreen<T> {

  // Buttons
  protected Button payBrokerFreeButton = null;
  protected Button giveMeSomeTimeButton = null;

  // Data access
  protected final int brokerFee;
  protected static final Item brokerItem = Items.EMERALD;

  // Text
  private List<FormattedCharSequence> textComponents = Collections.emptyList();
  protected int numberOfTextLines = 1;

  public ApartmentBrokerFeeScreen(T menu, Inventory inventory, Component component) {
    super(menu, inventory, component);
    this.brokerFee = menu.getApartmentBrokerFee();
  }

  @Override
  public void init() {
    super.init();

    // Pre-format text
    this.textComponents =
        this.font.split(Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "pay_broker_fee",
            this.localPlayer.getName(), this.brokerFee, brokerItem), this.imageWidth - 25);
    this.numberOfTextLines = this.textComponents.size();

    // Buttons
    int buttonStartTop = this.topPos + 150;
    this.payBrokerFreeButton = this.addRenderableWidget(Button
        .builder(Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "pay_broker_free_button",
            this.brokerFee, brokerItem), onPress -> {
              NetworkMessage.payBrokerFee();
              this.minecraftInstance.setScreen(null);
            })
        .bounds(this.leftPos + 15, buttonStartTop + 15, 270, 20).build());
    this.payBrokerFreeButton.active = false;

    this.giveMeSomeTimeButton = this.addRenderableWidget(Button.builder(
        Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "give_me_some_time_button"),
        onPress -> {
          this.minecraftInstance.setScreen(null);
        }).bounds(this.leftPos + 15, buttonStartTop + 50, 270, 20).build());
  }


  @Override
  public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
    super.render(guiGraphics, x, y, partialTicks);

    // Render text
    int textTopPos = this.topPos + 75;
    if (!this.textComponents.isEmpty()) {
      for (int line = 0; line < this.numberOfTextLines; ++line) {
        FormattedCharSequence formattedCharSequence = this.textComponents.get(line);
        guiGraphics.drawString(this.font, formattedCharSequence, leftPos + 15,
            textTopPos + (line * (font.lineHeight + 2)), Constants.FONT_COLOR_DEFAULT, false);
      }
    }

    // Check if player has enough money
    if (this.localPlayer.getInventory().countItem(Items.EMERALD) >= this.brokerFee) {
      this.payBrokerFreeButton.active = true;
    }
  }

}
