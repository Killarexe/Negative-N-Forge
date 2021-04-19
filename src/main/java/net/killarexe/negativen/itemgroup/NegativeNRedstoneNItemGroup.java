
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.item.RedstoneNItem;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NegativeNRedstoneNItemGroup extends NegativeNModElements.ModElement {
	public NegativeNRedstoneNItemGroup(NegativeNModElements instance) {
		super(instance, 744);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegative_n_redstone_n") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RedstoneNItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
