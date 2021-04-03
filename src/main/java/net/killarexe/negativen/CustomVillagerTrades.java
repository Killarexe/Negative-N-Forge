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
import net.killarexe.negativen.block.*;
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
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(HoeenDiamantNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(PiocheenDiamantNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(PelleenDiamantNItem.block), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.WEAPONSMITH){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(HacheendiamantNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(EpeeenDiamantNItem.block), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.ARMORER){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(ArnurendiamantinverseItem.helmet), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(ArnurendiamantinverseItem.body), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(ArnurendiamantinverseItem.legs), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(ArnurendiamantinverseItem.boots), 1, 0, 0));	
		}else if(event.getType() == VillagerProfession.CLERIC){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 8), new ItemStack(Items.ENDER_EYE), new ItemStack(StarteyeItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 8), new ItemStack(Items.LAPIS_BLOCK), new ItemStack(LapisLazuliNItem.block, 9), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 8), new ItemStack(Items.REDSTONE, 16), new ItemStack(RedstoneNItem.block, 16), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.FARMER){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 3), new ItemStack(Items.WHEAT, 16), new ItemStack(WheatNItem.block, 8), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 5), new ItemStack(Items.POTATO, 16), new ItemStack(PotatoNItem.block, 8), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 7), new ItemStack(Items.BEETROOT, 16), new ItemStack(BeetrootsNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 4), new ItemStack(Items.CARROT,16), new ItemStack(CarrotsNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 10), new ItemStack(Items.PUMPKIN), new ItemStack(PumpkinNBlock.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 10), new ItemStack(Items.MELON), new ItemStack(MelonNBlock.block), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.FLETCHER){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 32), new ItemStack(BowNItem.block), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 16), new ItemStack(Items.ARROW, 16), new ItemStack(ArrowNItem.block, 16), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.BUTCHER){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 8), new ItemStack(ChickenNFoodItem.block, 5), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 5), new ItemStack(BeefrawNItem.block, 5), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 6), new ItemStack(PorkchoprawNItem.block, 5), 1, 0, 0));
		}else if(event.getType() == VillagerProfession.LIBRARIAN){
			List<VillagerTrades.ITrade> trades = event.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 2), new ItemStack(PaperNItem.block, 5), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 4), new ItemStack(BookNItem.block, 5), 1, 0, 0));
			trades.add(new BasicTrade(new ItemStack(EmeraldNItem.block, 9), new ItemStack(BookshelfNBlock.block, 5), 1, 0, 0));
		}
	}
}
