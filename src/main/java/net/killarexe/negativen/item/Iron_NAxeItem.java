
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class Iron_NAxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:iron_n_axe")
	public static final Item block = null;

	public Iron_NAxeItem(NegativeNModElements instance) {
		super(instance, 285);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 15.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Iron_NIngotItem.block, (int) (1)));
			}
		}, 1, -1f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("entity", entity);
					$_dependencies.put("sourceentity", sourceentity);

					PoisonusProccedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setRegistryName("iron_n_axe"));
	}

}
