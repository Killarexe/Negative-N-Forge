
package net.killarexe.negativen.itemgroup;

@NegativeNModElements.ModElement.Tag
public class NegativeNFoodItemGroup extends NegativeNModElements.ModElement {

	public NegativeNFoodItemGroup(NegativeNModElements instance) {
		super(instance, 416);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativenfood") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AppleNItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
