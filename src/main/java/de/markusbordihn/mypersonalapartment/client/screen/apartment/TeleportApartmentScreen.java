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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.menu.apartment.TeleportApartmentMenu;
import de.markusbordihn.mypersonalapartment.network.NetworkMessage;

@OnlyIn(Dist.CLIENT)
public class TeleportApartmentScreen<T extends TeleportApartmentMenu> extends ApartmentScreen<T> {

  // Apartments
  Set<ApartmentData> apartments = new HashSet<>();

  // Buttons
  protected Button noButton = null;
  protected Button teleportBackButton = null;

  // Text
  private List<FormattedCharSequence> textComponents = Collections.emptyList();
  protected int numberOfTextLines = 1;

  // Cache
  private boolean isInApartmentDimension = false;

  public TeleportApartmentScreen(T menu, Inventory inventory, Component component) {
    super(menu, inventory, component);
    this.apartments = menu.getApartmentsData();
    this.isInApartmentDimension = this.clientLevel.dimension().location().toString()
        .equals(Constants.MOD_ID + ":apartments_dimension");
  }

  @Override
  public void init() {
    super.init();

    log.info("Init Teleport Apartment Screen for player {} with {} apartments", this.localPlayer,
        apartments.size());

    // Pre-format text
    this.textComponents = this.font.split(
        Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "teleport_apartment",
            this.localPlayer.getName(), COMMON.apartmentMaxNumberOfApartments.get()),
        this.imageWidth - 25);
    this.numberOfTextLines = this.textComponents.size();

    // Buttons
    this.noButton = this.addRenderableWidget(Button.builder(
        Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "teleport_apartment_no_button"),
        onPress -> {
          this.minecraftInstance.setScreen(null);
        }).bounds(this.leftPos + 50, this.topPos + 200, 200, 20).build());
    if (this.isInApartmentDimension) {
      this.teleportBackButton = this.addRenderableWidget(Button
          .builder(Component.translatable(Constants.TEXT_RECEPTION_PREFIX + "teleport_back_button"),
              onPress -> {
                log.info("Teleport back for player {}", this.localPlayer);
                NetworkMessage.teleportBack();
                this.minecraftInstance.setScreen(null);
              })
          .bounds(this.leftPos + 10, this.topPos + 175, 278, 20).build());
    }

    // Apartments List to teleport
    int apartmentTopPos = this.topPos + 50;
    int apartmentLeftPos = this.leftPos + 10;
    for (ApartmentData apartmentData : apartments) {
      MutableComponent apartmentName = Component.literal(apartmentData.getApartmentName());
      this.addRenderableWidget(Button.builder(apartmentName, onPress -> {
        log.info("Teleport to apartment {} for player {}", apartmentData.getApartmentUUID(),
            this.localPlayer);
        NetworkMessage.teleportToApartment(apartmentData.getApartmentUUID());
        this.minecraftInstance.setScreen(null);
      }).bounds(apartmentLeftPos, apartmentTopPos, 278, 20).build());
      apartmentTopPos += 25;
    }
  }

  @Override
  public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
    super.render(guiGraphics, x, y, partialTicks);

    // Render teleport text
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
