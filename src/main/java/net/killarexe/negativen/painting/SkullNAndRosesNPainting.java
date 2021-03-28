
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class SkullNAndRosesNPainting extends NegativeNModElements.ModElement {

	public SkullNAndRosesNPainting(NegativeNModElements instance) {
		super(instance, 868);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("skull_n_and_roses_n"));
	}

}
