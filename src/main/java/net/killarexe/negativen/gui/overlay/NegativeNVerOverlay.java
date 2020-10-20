
package net.killarexe.negativen.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.killarexe.negativen.procedures.NegativeNVerShowProcedure;
import net.killarexe.negativen.NegativenModElements;

import com.google.common.collect.ImmutableMap;

@NegativenModElements.ModElement.Tag
public class NegativeNVerOverlay extends NegativenModElements.ModElement {
	public NegativeNVerOverlay(NegativenModElements instance) {
		super(instance, 639);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (NegativeNVerShowProcedure.executeProcedure(ImmutableMap.of("entity", entity, "world", world))) {
				Minecraft.getInstance().fontRenderer.drawString("Negative-N 1.2.2", posX + -207, posY + -117, -1);
			}
		}
	}
}
