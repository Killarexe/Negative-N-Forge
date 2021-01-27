
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.item.AppleNItem;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class NegativeNFoodItemGroup extends NegativenModElements.ModElement {
	public NegativeNFoodItemGroup(NegativenModElements instance) {
		super(instance, 416);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativenfood") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AppleNItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
