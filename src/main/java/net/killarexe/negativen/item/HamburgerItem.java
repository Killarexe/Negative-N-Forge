
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class HamburgerItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:hamburger")
	public static final Item block = null;

	public HamburgerItem(NegativeNModElements instance) {
		super(instance, 315);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(1f)

							.build()));
			setRegistryName("hamburger");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				HamburgerFoodEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
