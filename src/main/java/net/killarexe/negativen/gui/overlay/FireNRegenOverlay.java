
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

import net.killarexe.negativen.procedures.FireNRegenDisplayOverlayIngameProcedure;
import net.killarexe.negativen.NegativeNModElements;

import com.google.common.collect.ImmutableMap;

@NegativeNModElements.ModElement.Tag
public class FireNRegenOverlay extends NegativeNModElements.ModElement {
	public FireNRegenOverlay(NegativeNModElements instance) {
		super(instance, 917);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (FireNRegenDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
			}
		}
	}
}
