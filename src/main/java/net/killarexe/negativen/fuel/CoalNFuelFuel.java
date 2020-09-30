
package net.killarexe.negativen.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.killarexe.negativen.item.CoalNItem;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class CoalNFuelFuel extends NegativenModElements.ModElement {
	public CoalNFuelFuel(NegativenModElements instance) {
		super(instance, 301);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CoalNItem.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}
}
