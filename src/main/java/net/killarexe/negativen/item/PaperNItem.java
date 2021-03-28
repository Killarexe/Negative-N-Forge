
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class PaperNItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:paper_n")
	public static final Item block = null;

	public PaperNItem(NegativeNModElements instance) {
		super(instance, 30);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("paper_n");
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
