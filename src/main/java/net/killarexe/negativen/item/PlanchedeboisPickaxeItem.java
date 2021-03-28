
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class PlanchedeboisPickaxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:wood_n_pickaxe")
	public static final Item block = null;

	public PlanchedeboisPickaxeItem(NegativeNModElements instance) {
		super(instance, 288);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 118;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlanchedeboisNBlock.block, (int) (1)), new ItemStack(AcaciaplanksnBlock.block, (int) (1)),
						new ItemStack(BirchplanksnBlock.block, (int) (1)), new ItemStack(DarkoakplanksNBlock.block, (int) (1)),
						new ItemStack(JunglePlanksNBlock.block, (int) (1)), new ItemStack(SprucePlanksNBlock.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("wood_n_pickaxe"));
	}

}
