
package net.killarexe.negativen;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;

import net.killarexe.negativen.item.LeatherNItem;
import net.killarexe.negativen.item.LavaNBottleNItem;
import net.killarexe.negativen.item.FrozenBottleNItem;

@NegativeNModElements.ModElement.Tag
public class FrozenBrewBrewingRecipe extends NegativeNModElements.ModElement {
	public FrozenBrewBrewingRecipe(NegativeNModElements instance) {
		super(instance, 1091);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(LavaNBottleNItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(LeatherNItem.block, (int) (1))), new ItemStack(FrozenBottleNItem.block, (int) (1)));
	}
}
