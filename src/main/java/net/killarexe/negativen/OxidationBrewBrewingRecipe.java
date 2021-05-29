
package net.killarexe.negativen;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;

import net.killarexe.negativen.item.WaterNBottleNItem;
import net.killarexe.negativen.item.OxidationBottleNItem;
import net.killarexe.negativen.block.WeatheredCopperNBlockBlock;

@NegativeNModElements.ModElement.Tag
public class OxidationBrewBrewingRecipe extends NegativeNModElements.ModElement {
	public OxidationBrewBrewingRecipe(NegativeNModElements instance) {
		super(instance, 1092);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(WaterNBottleNItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(WeatheredCopperNBlockBlock.block, (int) (1))),
				new ItemStack(OxidationBottleNItem.block, (int) (1)));
	}
}
