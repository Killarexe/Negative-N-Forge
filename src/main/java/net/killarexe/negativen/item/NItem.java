
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class NItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:n")
	public static final Item block = null;
	public NItem(NegativeNModElements instance) {
		super(instance, 541);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NegativeNModElements.sounds.get(new ResourceLocation("negative_n:n-music_8bit")),
					new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("n");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
