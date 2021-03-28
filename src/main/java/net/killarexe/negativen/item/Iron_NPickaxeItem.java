
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class Iron_NPickaxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:iron_n_pickaxe")
	public static final Item block = null;

	public Iron_NPickaxeItem(NegativeNModElements instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 0.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Iron_NIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("iron_n_pickaxe"));
	}

}
