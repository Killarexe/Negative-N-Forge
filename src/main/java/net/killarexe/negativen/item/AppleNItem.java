
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.killarexe.negativen.itemgroup.NegativeNFoodItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class AppleNItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:apple_n")
	public static final Item block = null;
	public AppleNItem(NegativeNModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.6f).build()));
			setRegistryName("apple_n");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
