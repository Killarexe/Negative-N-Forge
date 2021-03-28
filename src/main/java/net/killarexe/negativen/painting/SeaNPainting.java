
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class SeaNPainting extends NegativeNModElements.ModElement {

	public SeaNPainting(NegativeNModElements instance) {
		super(instance, 866);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 16).setRegistryName("sea_n"));
	}

}
