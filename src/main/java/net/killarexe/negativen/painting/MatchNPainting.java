
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class MatchNPainting extends NegativeNModElements.ModElement {

	public MatchNPainting(NegativeNModElements instance) {
		super(instance, 859);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("match_n"));
	}

}
