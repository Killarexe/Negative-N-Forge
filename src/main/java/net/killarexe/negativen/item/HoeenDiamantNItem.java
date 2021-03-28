
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class HoeenDiamantNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:diamond_n_hoe")
	public static final Item block = null;

	public HoeenDiamantNItem(NegativeNModElements instance) {
		super(instance, 283);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 1.3000000000000003f;
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
		}, 0, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

			@Override
			public ActionResultType onItemUse(ItemUseContext context) {
				ActionResultType retval = super.onItemUse(context);
				World world = context.getWorld();
				BlockPos pos = context.getPos();
				PlayerEntity entity = context.getPlayer();
				Direction direction = context.getFace();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				ItemStack itemstack = context.getItem();
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);

					HoeNRightClickOnDirtProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setRegistryName("diamond_n_hoe"));
	}

}
