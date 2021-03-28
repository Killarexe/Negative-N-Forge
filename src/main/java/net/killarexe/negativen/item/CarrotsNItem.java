
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class CarrotsNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:carrots_n")
	public static final Item block = null;

	public CarrotsNItem(NegativeNModElements instance) {
		super(instance, 320);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.2f)

							.build()));
			setRegistryName("carrots_n");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
