
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class SweetBerryNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:sweet_berry_n")
	public static final Item block = null;

	public SweetBerryNItem(NegativeNModElements instance) {
		super(instance, 324);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.1f)

							.build()));
			setRegistryName("sweet_berry_n");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 16;
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

	}

}
