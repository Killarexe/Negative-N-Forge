
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class BombNPainting extends NegativeNModElements.ModElement {

	public BombNPainting(NegativeNModElements instance) {
		super(instance, 853);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("bomb_n"));
	}

}
