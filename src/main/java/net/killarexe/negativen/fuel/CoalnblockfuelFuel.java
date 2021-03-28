
package net.killarexe.negativen.fuel;

@NegativeNModElements.ModElement.Tag
public class CoalnblockfuelFuel extends NegativeNModElements.ModElement {

	public CoalnblockfuelFuel(NegativeNModElements instance) {
		super(instance, 490);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CoalBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(6400);
	}

}
