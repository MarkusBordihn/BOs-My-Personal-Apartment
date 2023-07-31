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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Sets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.menu.apartment.ClaimApartmentMenu;
import de.markusbordihn.mypersonalapartment.network.NetworkMessage;


@OnlyIn(Dist.CLIENT)
public class ClaimApartmentScreen extends ApartmentScreen<ClaimApartmentMenu> {

  // Apartments
  List<String> tier1Apartments = new ArrayList<>(Sets.newHashSet(COMMON.apartmentsTier1.get()));

  // Buttons
  protected Button claimApartmentButton = null;
  protected Button showNextApartmentButton = null;
  protected Button showPreviousApartmentButton = null;

  // Text
  private List<FormattedCharSequence> textComponents = Collections.emptyList();
  protected int numberOfTextLines = 1;
  private List<FormattedCharSequence> apartmentDescriptionTextComponents = Collections.emptyList();
  protected int numberOfApartmentDescriptionTextLines = 1;

  // Cache
  protected String apartmentId = "";
  protected MutableComponent apartmentName;
  protected MutableComponent apartmentDescription;
  protected int apartmentIndex = 0;
  protected int apartmentIndexMax = this.tier1Apartments.size();
  protected ResourceLocation apartmentImage = null;

  public ClaimApartmentScreen(ClaimApartmentMenu menu, Inventory inventory, Component component) {
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
                      NetworkMessage.claimApartment(1, apartmentId);
                      this.minecraftInstance.setScreen(null);
                    })
                .bounds(this.leftPos + 15, this.topPos + 210, 270, 20).build());
    this.showPreviousApartmentButton =
        this.addRenderableWidget(Button.builder(
            Component.translatable(
                Constants.TEXT_RECEPTION_PREFIX + "show_previous_apartment_button", apartmentId),
            onPress -> {
              changeApartment(apartmentIndex - 1);
            }).bounds(this.leftPos + 15, this.topPos + 180, 125, 20).build());
    this.showNextApartmentButton =
        this.addRenderableWidget(
            Button.builder(
                Component.translatable(
                    Constants.TEXT_RECEPTION_PREFIX + "show_next_apartment_button", apartmentId),
                onPress -> {
                  changeApartment(apartmentIndex + 1);
                })
                .bounds(
                    this.showPreviousApartmentButton.getX()
                        + this.showPreviousApartmentButton.getWidth() + 20,
                    this.topPos + 180, 125, 20)
                .build());

    // Apartment Data
    changeApartment(apartmentIndex);
  }

  public void changeApartment(int apartmentIndex) {
    if (apartmentIndex < 0 || apartmentIndex >= this.apartmentIndexMax) {
      log.info("Apartment index {} is out of range!", apartmentIndex);
      return;
    }

    // Get additional apartment data from config and apartment index.
    this.apartmentIndex = apartmentIndex;
    this.apartmentId = this.tier1Apartments.get(this.apartmentIndex);
    String apartmentModId = this.apartmentId.split(":")[0];
    String apartmentIdName = this.apartmentId.replace(":", ".").replace("/", ".");
    this.apartmentName = Component.translatable("text." + apartmentIdName + ".name");
    this.apartmentDescription = Component.translatable("text."+ apartmentIdName + ".description");
    this.apartmentImage =
        new ResourceLocation(apartmentModId, "textures/" + this.apartmentId.split(":")[1] + ".png");
    log.info("Change apartment to {} ({}) with image {} with name {} and description {}",
        apartmentId, apartmentIdName, apartmentImage, apartmentName, apartmentDescription);

    // Pre-format apartment description text
    this.apartmentDescriptionTextComponents = this.font.split(this.apartmentDescription,
        this.imageWidth - 100);
    this.numberOfApartmentDescriptionTextLines = this.apartmentDescriptionTextComponents.size();
  }

  @Override
  public void render(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
    super.render(guiGraphics, x, y, partialTicks);

    // Render claim text
    int textTopPos = this.topPos + 20;
    if (!this.textComponents.isEmpty()) {
      for (int line = 0; line < this.numberOfTextLines; ++line) {
        FormattedCharSequence formattedCharSequence = this.textComponents.get(line);
        guiGraphics.drawString(this.font, formattedCharSequence, leftPos + 15,
            textTopPos + (line * (font.lineHeight + 2)), Constants.FONT_COLOR_DEFAULT, false);
      }
    }

    // Render apartment name
    guiGraphics.drawString(this.font, this.apartmentName, leftPos + 12, textTopPos + 39,
        Constants.FONT_COLOR_WHITE, true);

    // Render apartment description
    int apartmentDescriptionTextTopPos = textTopPos + 58;
    if (!this.apartmentDescriptionTextComponents.isEmpty()) {
      for (int line = 0; line < this.numberOfApartmentDescriptionTextLines; ++line) {
        FormattedCharSequence formattedCharSequence =
            this.apartmentDescriptionTextComponents.get(line);
        guiGraphics.drawString(this.font, formattedCharSequence, leftPos + 85,
            apartmentDescriptionTextTopPos + (line * (font.lineHeight + 2)),
            Constants.FONT_COLOR_DEFAULT, false);
      }
    }

    // Render apartment image scaled to 64x64
    if (this.apartmentImage != null) {
      guiGraphics.blit(this.apartmentImage, this.leftPos + 12, this.topPos + 75, 0, 0, 64, 64, 64,
          64);
    }

    // Render apartment costs
    guiGraphics.drawString(this.font, Component.literal("Cost: Free"), leftPos + 15,
        textTopPos + 134, Constants.FONT_COLOR_WHITE, false);

    // Render apartment buttons
    this.showNextApartmentButton.active = this.apartmentIndex < this.apartmentIndexMax - 1;
    this.showPreviousApartmentButton.active = this.apartmentIndex > 0;
  }

  @Override
  protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
    super.renderBg(guiGraphics, partialTicks, mouseX, mouseY);

    // Apartment background
    guiGraphics.fill(this.contentLeftPos, this.topPos + 55, this.contentLeftPos + 283,
        this.topPos + 171, 0xff000000);
    guiGraphics.fill(this.contentLeftPos + 1, this.topPos + 56, this.contentLeftPos + 282,
        this.topPos + 170, 0xffaaaaaa);

    // Apartment title
    guiGraphics.fill(this.contentLeftPos + 1, this.topPos + 56, this.contentLeftPos + 282,
        this.topPos + 70, 0xff333333);

    // Apartment image border
    guiGraphics.fill(this.contentLeftPos + 5, this.topPos + 74, this.contentLeftPos + 71,
        this.topPos + 140, 0xff333333);

    // Apartment costs
    guiGraphics.fill(this.contentLeftPos + 1, this.topPos + 145, this.contentLeftPos + 282,
        this.topPos + 170, 0xff333333);

    // Apartment description border
    guiGraphics.fill(this.contentLeftPos + 75, this.topPos + 74, this.contentLeftPos + 278,
        this.topPos + 140, 0xff999999);
    guiGraphics.fill(this.contentLeftPos + 76, this.topPos + 75, this.contentLeftPos + 277,
        this.topPos + 139, 0xffbbbbbb);

  }

}
