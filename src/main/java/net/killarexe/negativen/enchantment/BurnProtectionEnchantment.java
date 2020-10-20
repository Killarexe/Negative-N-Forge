
package net.killarexe.negativen.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class BurnProtectionEnchantment extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:burn_protection")
	public static final Enchantment enchantment = null;
	public BurnProtectionEnchantment(NegativenModElements instance) {
		super(instance, 634);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("burn_protection"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, slots);
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
			if (stack.getItem() == new ItemStack(Items.LEATHER_CHESTPLATE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.CHAINMAIL_CHESTPLATE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_CHESTPLATE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_CHESTPLATE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
