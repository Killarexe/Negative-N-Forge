
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class GoldNPickaxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:gold_n_pickaxe")
	public static final Item block = null;

	public GoldNPickaxeItem(NegativeNModElements instance) {
		super(instance, 296);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 64;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GoldNIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("gold_n_pickaxe"));
	}

}
