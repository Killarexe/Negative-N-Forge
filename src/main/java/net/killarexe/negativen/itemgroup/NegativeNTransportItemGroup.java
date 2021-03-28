
package net.killarexe.negativen.itemgroup;

@NegativeNModElements.ModElement.Tag
public class NegativeNTransportItemGroup extends NegativeNModElements.ModElement {

	public NegativeNTransportItemGroup(NegativeNModElements instance) {
		super(instance, 793);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegative_n_transport") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OakNBoatItemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
