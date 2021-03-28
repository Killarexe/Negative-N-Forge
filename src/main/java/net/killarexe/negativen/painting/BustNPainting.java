
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class BustNPainting extends NegativeNModElements.ModElement {

	public BustNPainting(NegativeNModElements instance) {
		super(instance, 855);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("bust_n"));
	}

}
