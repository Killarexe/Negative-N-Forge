
package net.killarexe.negativen.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.killarexe.negativen.item.PlanchedeboisSwordItem;
import net.killarexe.negativen.item.PlanchedeboisAxeItem;
import net.killarexe.negativen.item.Iron_NSwordItem;
import net.killarexe.negativen.item.Iron_NAxeItem;
import net.killarexe.negativen.item.HacheendiamantNItem;
import net.killarexe.negativen.item.EpeeenDiamantNItem;
import net.killarexe.negativen.item.CobblestoneSwordItem;
import net.killarexe.negativen.item.CobblestoneAxeItem;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class PoisonusEnchantment extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:poisonus")
	public static final Enchantment enchantment = null;
	public PoisonusEnchantment(NegativenModElements instance) {
		super(instance, 556);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("poisonus"));
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
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(EpeeenDiamantNItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(HacheendiamantNItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Iron_NAxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Iron_NSwordItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlanchedeboisAxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(PlanchedeboisSwordItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(CobblestoneAxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(CobblestoneSwordItem.block, (int) (1)).getItem())
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
