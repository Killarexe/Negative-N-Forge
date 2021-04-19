
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.killarexe.negativen.itemgroup.NegativeNCombatItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class ArrowNItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:arrow_n")
	public static final Item block = null;
	public ArrowNItem(NegativeNModElements instance) {
		super(instance, 356);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NegativeNCombatItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("arrow_n");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
