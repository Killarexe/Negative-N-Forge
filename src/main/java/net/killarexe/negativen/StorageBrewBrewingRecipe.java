
package net.killarexe.negativen;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.item.RawGoldNItem;

@NegativeNModElements.ModElement.Tag
public class StorageBrewBrewingRecipe extends NegativeNModElements.ModElement {
	public StorageBrewBrewingRecipe(NegativeNModElements instance) {
		super(instance, 1016);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(RawGoldNItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.CHEST, (int) (1))), new ItemStack(Items.POTION, (int) (1)));
	}
}
