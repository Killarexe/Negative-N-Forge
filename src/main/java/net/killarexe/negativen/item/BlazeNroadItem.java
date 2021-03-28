
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class BlazeNroadItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:blaze_n_road")
	public static final Item block = null;

	public BlazeNroadItem(NegativeNModElements instance) {
		super(instance, 17);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blaze_n_road");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
