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

package de.markusbordihn.mypersonalapartment;

import net.minecraft.resources.ResourceLocation;

public final class Constants {

  protected Constants() {}

  // General Mod definitions
  public static final String LOG_NAME = "Bo's My Personal Apartment";
  public static final String LOG_ICON = "🏢";
  public static final String LOG_ICON_NAME = LOG_ICON + " " + LOG_NAME;
  public static final String LOG_PREFIX = LOG_ICON + " My Personal Apartment: ";
  public static final String LOG_REGISTER_PREFIX = LOG_ICON + " Register My Personal Apartment";
  public static final String MOD_COMMAND = "my_personal_apartment";
  public static final String MOD_ID = "my_personal_apartment";
  public static final String MOD_NAME = "Bo's My Personal Apartment";
  public static final String MOD_URL =
      "https://www.curseforge.com/minecraft/mc-mods/my_personal_apartment";

  // Prefixes
  public static final String MINECRAFT_PREFIX = "minecraft";
  public static final String MESSAGE_PREFIX = "message.my_personal_apartment.";
  public static final String TEXT_PREFIX = "text.my_personal_apartment.";
  public static final String TEXT_RECEPTION_PREFIX = TEXT_PREFIX + "reception.";
  public static final String TEXT_APARTMENT_PREFIX = TEXT_PREFIX + "apartment.";
  public static final String LOG_DIMENSION_MANAGER_PREFIX =
      "[My Personal Apartment: Dimension Manager]";
  public static final String LOG_TELEPORT_MANAGER_PREFIX =
      "[My Personal Apartment: Teleport Manager]";
  public static final String LOG_PLAYER_MANAGER_PREFIX = "[My Personal Apartment: Player Manager]";

  // Colors
  public static final int FONT_COLOR_BLACK = 0;
  public static final int FONT_COLOR_DARK_GREEN = 43520;
  public static final int FONT_COLOR_DEFAULT = 4210752;
  public static final int FONT_COLOR_GRAY = 11184810;
  public static final int FONT_COLOR_GREEN = 5635925;
  public static final int FONT_COLOR_RED = 16733525;
  public static final int FONT_COLOR_WHITE = 16777215;
  public static final int FONT_COLOR_YELLOW = 16777045;

  // Textures
  public static final ResourceLocation TEXTURE_DEMO_BACKGROUND =
      new ResourceLocation(MINECRAFT_PREFIX, "textures/gui/demo_background.png");

}
