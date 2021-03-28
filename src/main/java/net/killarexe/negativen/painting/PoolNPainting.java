
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class PoolNPainting extends NegativeNModElements.ModElement {

	public PoolNPainting(NegativeNModElements instance) {
		super(instance, 865);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("pool_n"));
	}

}
