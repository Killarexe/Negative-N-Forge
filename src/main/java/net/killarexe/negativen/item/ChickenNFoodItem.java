
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class ChickenNFoodItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:chicken_n_food")
	public static final Item block = null;

	public ChickenNFoodItem(NegativeNModElements instance) {
		super(instance, 318);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.5f)

							.meat().build()));
			setRegistryName("chicken_n_food");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
