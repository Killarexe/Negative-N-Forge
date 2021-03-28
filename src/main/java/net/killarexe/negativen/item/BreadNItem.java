
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class BreadNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:bread_n")
	public static final Item block = null;

	public BreadNItem(NegativeNModElements instance) {
		super(instance, 321);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.4f)

							.build()));
			setRegistryName("bread_n");
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
