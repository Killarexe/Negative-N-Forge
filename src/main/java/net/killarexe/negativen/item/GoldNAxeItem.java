
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class GoldNAxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:gold_n_axe")
	public static final Item block = null;

	public GoldNAxeItem(NegativeNModElements instance) {
		super(instance, 297);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 55;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 4f;
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

		}.setRegistryName("gold_n_axe"));
	}

}
