
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class MelonNSliceItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:melon_n_slice")
	public static final Item block = null;

	public MelonNSliceItem(NegativeNModElements instance) {
		super(instance, 904);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f)

							.build()));
			setRegistryName("melon_n_slice");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
