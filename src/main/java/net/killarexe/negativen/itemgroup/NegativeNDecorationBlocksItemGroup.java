
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.block.PeonyNBlock;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NegativeNDecorationBlocksItemGroup extends NegativeNModElements.ModElement {
	public NegativeNDecorationBlocksItemGroup(NegativeNModElements instance) {
		super(instance, 591);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegative_n_decoration_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PeonyNBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
