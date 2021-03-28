
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class RedstoneNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:redstone_n")
	public static final Item block = null;

	public RedstoneNItem(NegativeNModElements instance) {
		super(instance, 152);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(NegativeNRedstoneNItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("redstone_n");
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
