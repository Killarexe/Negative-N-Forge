
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class BakedPotatoNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:baked_potato_n")
	public static final Item block = null;

	public BakedPotatoNItem(NegativeNModElements instance) {
		super(instance, 323);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.1f)

							.build()));
			setRegistryName("baked_potato_n");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
