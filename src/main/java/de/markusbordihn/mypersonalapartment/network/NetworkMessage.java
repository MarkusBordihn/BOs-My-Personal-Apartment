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

package de.markusbordihn.mypersonalapartment.network;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.network.message.MessageClaimApartment;
import de.markusbordihn.mypersonalapartment.network.message.MessagePayBrokerFee;
import de.markusbordihn.mypersonalapartment.network.message.MessageTeleportBack;
import de.markusbordihn.mypersonalapartment.network.message.MessageTeleportToApartment;

public class NetworkMessage {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected NetworkMessage() {}

  /** Pay broker fee. */
  public static void payBrokerFee() {
    NetworkHandler.sendToServer(new MessagePayBrokerFee());
  }

  /** Claim apartment */
  public static void claimApartment(int tier, String apartmentId) {
    if (tier > 0 && tier <= 3 && apartmentId != null && !apartmentId.isEmpty()) {
      NetworkHandler.sendToServer(new MessageClaimApartment(tier, apartmentId));
    }
  }

  /** Teleport to apartment */
  public static void teleportToApartment(UUID apartmentId) {
    if (apartmentId != null) {
      NetworkHandler.sendToServer(new MessageTeleportToApartment(apartmentId));
    }
  }

  /** Teleport back */
  public static void teleportBack() {
    NetworkHandler.sendToServer(new MessageTeleportBack());
  }

}
