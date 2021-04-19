
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.item.LavaNbucketItem;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NegativeNRessouresItemGroup extends NegativeNModElements.ModElement {
	public NegativeNRessouresItemGroup(NegativeNModElements instance) {
		super(instance, 440);
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
