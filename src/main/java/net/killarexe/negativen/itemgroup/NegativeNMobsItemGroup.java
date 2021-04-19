
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.item.RottenfleshNItem;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NegativeNMobsItemGroup extends NegativeNModElements.ModElement {
	public NegativeNMobsItemGroup(NegativeNModElements instance) {
		super(instance, 636);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegative_n_mobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RottenfleshNItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
