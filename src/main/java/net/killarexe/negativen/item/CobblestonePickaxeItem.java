
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class CobblestonePickaxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:cobblestone_n_pickaxe")
	public static final Item block = null;

	public CobblestonePickaxeItem(NegativeNModElements instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 262;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 0.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CobblestoneNBlock.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

		}.setRegistryName("cobblestone_n_pickaxe"));
	}

}
