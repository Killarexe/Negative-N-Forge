
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class NetheriteNSwordItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:netherite_n_sword")
	public static final Item block = null;

	public NetheriteNSwordItem(NegativeNModElements instance) {
		super(instance, 268);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4683;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 12f;
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
		}, 3, -3f, new Item.Properties().group(NegativeNCombatItemGroup.tab).isImmuneToFire()) {

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

		}.setRegistryName("netherite_n_sword"));
	}

}
