
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class GrahamNPainting extends NegativeNModElements.ModElement {

	public GrahamNPainting(NegativeNModElements instance) {
		super(instance, 860);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 32).setRegistryName("graham_n"));
	}

}
