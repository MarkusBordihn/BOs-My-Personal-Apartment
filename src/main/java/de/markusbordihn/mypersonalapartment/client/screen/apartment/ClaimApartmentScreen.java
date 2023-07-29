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

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.menu.apartment.ClaimApartmentMenu;


@OnlyIn(Dist.CLIENT)
public class ClaimApartmentScreen<T extends ClaimApartmentMenu> extends ApartmentScreen<T> {

  // Buttons
  protected Button claimApartmentButton = null;
  protected Button showNextApartmentButton = null;
  protected Button showPreviousApartmentButton = null;

  // Text
  private List<FormattedCharSequence> textComponents = Collections.emptyList();
  protected int numberOfTextLines = 1;

  // Cache
  protected String apartmentId = "";

  public ClaimApartmentScreen(T menu, Inventory inventory, Component component) {
    super(menu, inventory, component);
  }

  @Override
  public void init() {
    super.init();

    // Pre-format text
    this.textComponents = this.font.split(
        Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "claim_apartment",
            this.localPlayer.getName(), COMMON.apartmentMaxNumberOfApartments.get()),
        this.imageWidth - 25);
    this.numberOfTextLines = this.textComponents.size();

    // Buttons
    this.claimApartmentButton =
        this.addRenderableWidget(
            Button
                .builder(
                    Component.translatable(
                        Constants.TEXT_RECEPTION_PREFIX + "claim_apartment_button", apartmentId),
                    onPress -> {
                      if (apartmentId.isEmpty()) {
                        log.error("Apartment ID is empty!");
                        return;
                      }
                      log.info("Claim apartment {}", apartmentId);
                    })
                .bounds(this.leftPos + 15, this.topPos + 210, 270, 20).build());
    this.showPreviousApartmentButton =
        this.addRenderableWidget(Button.builder(
            Component.translatable(
                Constants.TEXT_RECEPTION_PREFIX + "show_previous_apartment_button", apartmentId),
            onPress -> {
              log.info("Show previous apartment");
            }).bounds(this.leftPos + 15, this.topPos + 180, 125, 20).build());
    this.showNextApartmentButton =
        this.addRenderableWidget(
            Button.builder(
                Component.translatable(
                    Constants.TEXT_RECEPTION_PREFIX + "show_next_apartment_button", apartmentId),
                onPress -> {
                  log.info("Show next apartment");
                })
                .bounds(
                    this.showPreviousApartmentButton.getX()
                        + this.showPreviousApartmentButton.getWidth() + 20,
                    this.topPos + 180, 125, 20)
                .build());
  }

  @Override
  public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
    super.render(guiGraphics, x, y, partialTicks);

    // Render text
    int textTopPos = this.topPos + 20;
    if (!this.textComponents.isEmpty()) {
      for (int line = 0; line < this.numberOfTextLines; ++line) {
        FormattedCharSequence formattedCharSequence = this.textComponents.get(line);
        guiGraphics.drawString(this.font, formattedCharSequence, leftPos + 15,
            textTopPos + (line * (font.lineHeight + 2)), Constants.FONT_COLOR_DEFAULT, false);
      }
    }

  }

}
