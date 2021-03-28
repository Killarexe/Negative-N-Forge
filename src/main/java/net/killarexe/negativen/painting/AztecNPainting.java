
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class AztecNPainting extends NegativeNModElements.ModElement {

	public AztecNPainting(NegativeNModElements instance) {
		super(instance, 851);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("aztec_n"));
	}

}
