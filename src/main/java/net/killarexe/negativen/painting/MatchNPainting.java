
package net.killarexe.negativen.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class MatchNPainting extends NegativeNModElements.ModElement {
	public MatchNPainting(NegativeNModElements instance) {
		super(instance, 879);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("match_n"));
	}
}
