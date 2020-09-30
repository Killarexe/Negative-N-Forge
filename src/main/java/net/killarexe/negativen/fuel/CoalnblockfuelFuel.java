
package net.killarexe.negativen.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.killarexe.negativen.block.CoalBlockBlock;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class CoalnblockfuelFuel extends NegativenModElements.ModElement {
	public CoalnblockfuelFuel(NegativenModElements instance) {
		super(instance, 382);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CoalBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(6400);
	}
}
