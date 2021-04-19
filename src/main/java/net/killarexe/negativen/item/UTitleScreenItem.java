
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.killarexe.negativen.itemgroup.NegativeNRessouresItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class UTitleScreenItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:easter_egg")
	public static final Item block = null;
	public UTitleScreenItem(NegativeNModElements instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NegativeNModElements.sounds.get(new ResourceLocation("negative_n:easter_egg")),
					new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("easter_egg");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
