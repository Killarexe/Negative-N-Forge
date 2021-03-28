
package net.killarexe.negativen.painting;

@NegativeNModElements.ModElement.Tag
public class PlantNPainting extends NegativeNModElements.ModElement {

	public PlantNPainting(NegativeNModElements instance) {
		super(instance, 863);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("plant_n"));
	}

}
