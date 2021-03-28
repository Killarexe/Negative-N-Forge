
package net.killarexe.negativen.enchantment;

@NegativeNModElements.ModElement.Tag
public class EyewearEnchantment extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:eyewear")
	public static final Enchantment enchantment = null;

	public EyewearEnchantment(NegativeNModElements instance) {
		super(instance, 922);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("eyewear"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_HEAD, slots);
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
