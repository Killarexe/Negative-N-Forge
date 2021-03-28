
package net.killarexe.negativen.itemgroup;

@NegativeNModElements.ModElement.Tag
public class NeagtiveNOuilsItemGroup extends NegativeNModElements.ModElement {

	public NeagtiveNOuilsItemGroup(NegativeNModElements instance) {
		super(instance, 379);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabneagtivenouils") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Iron_NAxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
