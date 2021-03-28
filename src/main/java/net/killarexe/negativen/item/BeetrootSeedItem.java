
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class BeetrootSeedItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:beetroot_seed")
	public static final Item block = null;

	public BeetrootSeedItem(NegativeNModElements instance) {
		super(instance, 42);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("beetroot_seed");
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

	}

}
