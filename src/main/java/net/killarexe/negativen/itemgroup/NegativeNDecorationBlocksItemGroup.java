
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.block.TorchNState2Block;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class NegativeNDecorationBlocksItemGroup extends NegativenModElements.ModElement {
	public NegativeNDecorationBlocksItemGroup(NegativenModElements instance) {
		super(instance, 484);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegative_n_decoration_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TorchNState2Block.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
