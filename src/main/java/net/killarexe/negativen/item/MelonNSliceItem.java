
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
public class MelonNSliceItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:melon_n_slice")
	public static final Item block = null;
	public MelonNSliceItem(NegativeNModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f).build()));
			setRegistryName("melon_n_slice");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
