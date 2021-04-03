
package net.killarexe.negativen.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class WitheredEnchantment extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:withered")
	public static final Enchantment enchantment = null;
	public WitheredEnchantment(NegativeNModElements instance) {
		super(instance, 924);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("withered"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 2;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == PoisonusEnchantment.enchantment)
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
