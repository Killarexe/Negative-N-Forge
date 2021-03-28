
package net.killarexe.negativen.itemgroup;

@NegativeNModElements.ModElement.Tag
public class NegativeNRessouresItemGroup extends NegativeNModElements.ModElement {

	public NegativeNRessouresItemGroup(NegativeNModElements instance) {
		super(instance, 380);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativenressoures") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LavaNbucketItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
