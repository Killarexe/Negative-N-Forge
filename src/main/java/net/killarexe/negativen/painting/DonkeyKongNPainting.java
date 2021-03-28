
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class DonkeyKongNPainting extends NegativeNModElements.ModElement {

	public DonkeyKongNPainting(NegativeNModElements instance) {
		super(instance, 857);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("donkey_kong_n"));
	}

}
