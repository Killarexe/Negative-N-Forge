
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.block.BricksBlockNBlock;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NegativeNBlocksItemGroup extends NegativeNModElements.ModElement {
	public NegativeNBlocksItemGroup(NegativeNModElements instance) {
		super(instance, 441);
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
