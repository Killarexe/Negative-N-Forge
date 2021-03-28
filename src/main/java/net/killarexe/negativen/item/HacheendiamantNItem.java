
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class HacheendiamantNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:diamond_n_axe")
	public static final Item block = null;

	public HacheendiamantNItem(NegativeNModElements instance) {
		super(instance, 281);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3122;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 21f;
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

		}.setRegistryName("diamond_n_axe"));
	}

}
