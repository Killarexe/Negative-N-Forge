
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class BruningSkullNPainting extends NegativeNModElements.ModElement {

	public BruningSkullNPainting(NegativeNModElements instance) {
		super(instance, 854);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("bruning_skull_n"));
	}

}
