
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class CreebetNPainting extends NegativeNModElements.ModElement {

	public CreebetNPainting(NegativeNModElements instance) {
		super(instance, 856);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 16).setRegistryName("creebet_n"));
	}

}
