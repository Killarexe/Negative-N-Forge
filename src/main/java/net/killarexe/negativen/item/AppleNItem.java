
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class AppleNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:apple_n")
	public static final Item block = null;

	public AppleNItem(NegativeNModElements instance) {
		super(instance, 317);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.6f)

							.build()));
			setRegistryName("apple_n");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
