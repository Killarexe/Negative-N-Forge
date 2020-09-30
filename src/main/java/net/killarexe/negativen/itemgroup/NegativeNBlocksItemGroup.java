
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.block.BlockdediamantInverseBlock;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class NegativeNBlocksItemGroup extends NegativenModElements.ModElement {
	public NegativeNBlocksItemGroup(NegativenModElements instance) {
		super(instance, 273);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativenblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlockdediamantInverseBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
