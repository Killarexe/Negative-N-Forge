
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class FightersNPainting extends NegativeNModElements.ModElement {

	public FightersNPainting(NegativeNModElements instance) {
		super(instance, 858);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 16).setRegistryName("fighters_n"));
	}

}
