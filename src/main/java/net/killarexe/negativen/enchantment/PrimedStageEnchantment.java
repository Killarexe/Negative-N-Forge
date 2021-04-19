
package net.killarexe.negativen.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.block.TNTNBlock;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class PrimedStageEnchantment extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:primed_stage")
	public static final Enchantment enchantment = null;
	public PrimedStageEnchantment(NegativeNModElements instance) {
		super(instance, 996);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("primed_stage"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(TNTNBlock.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Blocks.TNT, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.END_CRYSTAL, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return true;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
