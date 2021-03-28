
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class SkeletonNPaintPainting extends NegativeNModElements.ModElement {

	public SkeletonNPaintPainting(NegativeNModElements instance) {
		super(instance, 867);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("skeleton_n_paint"));
	}

}
