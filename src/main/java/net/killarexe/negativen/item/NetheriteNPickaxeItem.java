
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class NetheriteNPickaxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:netherite_n_pickaxe")
	public static final Item block = null;

	public NetheriteNPickaxeItem(NegativeNModElements instance) {
		super(instance, 276);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4683;
			}

			public float getEfficiency() {
				return 25f;
			}

			public float getAttackDamage() {
				return 3.5f;
			}

			public int getHarvestLevel() {
				return 9;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NetheriteNItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab).isImmuneToFire()) {

		}.setRegistryName("netherite_n_pickaxe"));
	}

}
