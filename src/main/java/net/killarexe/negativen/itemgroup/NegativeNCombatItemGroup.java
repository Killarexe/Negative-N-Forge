
package net.killarexe.negativen.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.killarexe.negativen.item.GoldNSwordItem;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class NegativeNCombatItemGroup extends NegativenModElements.ModElement {
	public NegativeNCombatItemGroup(NegativenModElements instance) {
		super(instance, 378);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnegativencombat") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GoldNSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
