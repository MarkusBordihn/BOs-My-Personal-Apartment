/**
 * Copyright 2022 Markus Bordihn
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

package de.markusbordihn.mypersonalapartment.datapack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.server.level.ServerLevel;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.commands.CommandManager;
import de.markusbordihn.mypersonalapartment.data.ApartmentData;
import de.markusbordihn.mypersonalapartment.dimension.DimensionManager;

public class DataPackHandler {

  public static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected DataPackHandler() {}

  public static void prepareDataPackOnce(ServerLevel level) {
    if (level == DimensionManager.getApartmentDimension()) {
      if (ApartmentData.get().getDimensionLoaded()) {
        log.info("Skip Data Pack for Apartment dimension {} because it was already loaded!", level);
      } else {
        prepareDataPack(level);
        ApartmentData.get().setDimensionLoaded(true);
      }
    } else {
      log.warn("Unable to get status for level {} to confirm data pack load status!", level);
    }
  }

  public static void prepareDataPack(ServerLevel level) {
    String dataPackFunction = Constants.MOD_ID + ":apartments_load";
    log.info("Loading data pack with {} for level {} ...", dataPackFunction, level);
    CommandManager.executeServerFunction(dataPackFunction, level);
  }
}
