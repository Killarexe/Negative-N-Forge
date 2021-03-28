
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class PigNScenePainting extends NegativeNModElements.ModElement {

	public PigNScenePainting(NegativeNModElements instance) {
		super(instance, 862);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("pig_n_scene"));
	}

}
