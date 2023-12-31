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

package de.markusbordihn.mypersonalapartment.client.renderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;

import de.markusbordihn.mypersonalapartment.Constants;
import de.markusbordihn.mypersonalapartment.client.renderer.receptionist.ReceptionistRenderer;
import de.markusbordihn.mypersonalapartment.entity.npc.ModEntityType;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer {

    protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ClientRenderer() {}

  public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
    log.info("{} Entity Renders ...", Constants.LOG_REGISTER_PREFIX);

    // Receptionist NPC Entity
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_ALEX.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_ARI.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_EFE.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_KAI.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_MAKENA.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_NOOR.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_STEVE.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_SUNNY.get(), ReceptionistRenderer::new);
    event.registerEntityRenderer(ModEntityType.RECEPTIONIST_ZURI.get(), ReceptionistRenderer::new);
  }

}
