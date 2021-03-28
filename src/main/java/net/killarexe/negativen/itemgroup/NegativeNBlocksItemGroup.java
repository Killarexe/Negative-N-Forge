
package net.killarexe.negativen.itemgroup;

@NegativeNModElements.ModElement.Tag
public class NegativeNBlocksItemGroup extends NegativeNModElements.ModElement {

	public NegativeNBlocksItemGroup(NegativeNModElements instance) {
		super(instance, 381);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativenblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BricksBlockNBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
