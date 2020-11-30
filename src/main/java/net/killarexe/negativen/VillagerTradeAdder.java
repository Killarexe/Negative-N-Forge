/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class NegativenModElements.ModElement.
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraftforge.common.BasicTrade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.killarexe.negativen.item.*;
import java.util.List;

@NegativenModElements.ModElement.Tag
public class VillagerTradeAdder extends NegativenModElements.ModElement {
	/**
	 * Do not remove this constructor
	 */
	public VillagerTradeAdder(NegativenModElements instance) {
		super(instance, 871);
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

	public void addNewTrade(VillagerTradesEvent event){

		if(event.getType() == VillagerProfession.WEAPONSMITH){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(1);

			trades.add(new BasicTrade(new ItemStack(Items.EMERALD), new ItemStack(Iron_NSwordItem.block), 1, 1, 0));
		}
			
	}
	
}
