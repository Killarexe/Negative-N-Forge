
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class AztecN2Painting extends NegativeNModElements.ModElement {

	public AztecN2Painting(NegativeNModElements instance) {
		super(instance, 852);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("aztec_n_2"));
	}

}
