
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class AlbanNPainting extends NegativeNModElements.ModElement {

	public AlbanNPainting(NegativeNModElements instance) {
		super(instance, 850);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("alban_n"));
	}

}
