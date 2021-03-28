
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class GoldNShovelItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:gold_n_shovel")
	public static final Item block = null;

	public GoldNShovelItem(NegativeNModElements instance) {
		super(instance, 298);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 64;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 44;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GoldNIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("gold_n_shovel"));
	}

}
