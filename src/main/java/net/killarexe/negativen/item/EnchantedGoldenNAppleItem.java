
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class EnchantedGoldenNAppleItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:enchanted_golden_n_apple")
	public static final Item block = null;

	public EnchantedGoldenNAppleItem(NegativeNModElements instance) {
		super(instance, 1005);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(20).saturation(20f).setAlwaysEdible()

							.build()));
			setRegistryName("enchanted_golden_n_apple");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 128;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(AppleNItem.block, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				EnchantedGoldenNAppleFoodEatenProcedure.executeProcedure($_dependencies);
			}

			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}

	}

}
