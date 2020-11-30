
package net.killarexe.negativen.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class BombNPainting extends NegativenModElements.ModElement {
	public BombNPainting(NegativenModElements instance) {
		super(instance, 853);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("bomb_n"));
	}
}
