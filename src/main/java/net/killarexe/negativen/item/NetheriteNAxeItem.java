
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class NetheriteNAxeItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:netherite_n_axe")
	public static final Item block = null;

	public NetheriteNAxeItem(NegativeNModElements instance) {
		super(instance, 277);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3122;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 31f;
			}

			public int getHarvestLevel() {
				return 9;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DiamantinverseItem.block, (int) (1)));
			}
		}, 1, -1f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab).isImmuneToFire()) {

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

		}.setRegistryName("netherite_n_axe"));
	}

}
