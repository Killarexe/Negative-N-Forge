
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class PiocheenDiamantNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:diamond_n_pickaxe")
	public static final Item block = null;

	public PiocheenDiamantNItem(NegativeNModElements instance) {
		super(instance, 280);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3122;
			}

			public float getEfficiency() {
				return 25f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DiamantinverseItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("diamond_n_pickaxe"));
	}

}
