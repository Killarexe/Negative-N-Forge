
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class PointerNPainting extends NegativeNModElements.ModElement {

	public PointerNPainting(NegativeNModElements instance) {
		super(instance, 864);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("pointer_n"));
	}

}
