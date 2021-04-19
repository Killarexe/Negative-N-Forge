
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.killarexe.negativen.itemgroup.NegativeNRessouresItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class BlazeNpowderItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:blaze_n_powder")
	public static final Item block = null;
	public BlazeNpowderItem(NegativeNModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blaze_n_powder");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
