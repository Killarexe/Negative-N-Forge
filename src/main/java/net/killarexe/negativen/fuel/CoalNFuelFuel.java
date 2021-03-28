
package net.killarexe.negativen.fuel;

@NegativeNModElements.ModElement.Tag
public class CoalNFuelFuel extends NegativeNModElements.ModElement {

	public CoalNFuelFuel(NegativeNModElements instance) {
		super(instance, 409);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CoalNItem.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}

}
