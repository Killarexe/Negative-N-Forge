/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class NegativeNModElements.ModElement.
 *
 * You can register new events in this class too.
 *
 * As this class is loaded into mod element list, it NEEDS to extend
 * ModElement class. If you remove this extend statement or remove the
 * constructor, the compilation will fail.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser - New... and make sure to make the class
 * outside net.killarexe.negativen as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
*/
package net.killarexe.negativen;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import java.util.List;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraftforge.common.BasicTrade;
import net.minecraft.item.ItemStack;
import net.killarexe.negativen.item.*;
import net.minecraft.item.Items;

@NegativeNModElements.ModElement.Tag
public class CustomVillagerTrades extends NegativeNModElements.ModElement {
	/**
	 * Do not remove this constructor
	 */
	public CustomVillagerTrades(NegativeNModElements instance) {
		super(instance, 1023);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void clientLoad(FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public void addCustomTrade(VillagerTradesEvent event){
		if(event.getType() == VillagerProfession.TOOLSMITH){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.NETHERITE_HOE), new ItemStack(HoeenDiamantNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.NETHERITE_PICKAXE), new ItemStack(PiocheenDiamantNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.NETHERITE_SHOVEL), new ItemStack(PelleenDiamantNItem.block), 1, 0, 0));
		}
	}
}
