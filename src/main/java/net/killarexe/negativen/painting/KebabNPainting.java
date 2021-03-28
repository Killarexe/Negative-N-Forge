
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class KebabNPainting extends NegativeNModElements.ModElement {

	public KebabNPainting(NegativeNModElements instance) {
		super(instance, 861);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("kebab_n"));
	}

}
