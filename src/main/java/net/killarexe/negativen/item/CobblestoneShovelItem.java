
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class CobblestoneShovelItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:cobblestone_n_shovel")
	public static final Item block = null;

	public CobblestoneShovelItem(NegativeNModElements instance) {
		super(instance, 294);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 262;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("cobblestone_n_shovel"));
	}

}
