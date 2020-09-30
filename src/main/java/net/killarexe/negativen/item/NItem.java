
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class NItem extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:n")
	public static final Item block = null;
	public NItem(NegativenModElements instance) {
		super(instance, 434);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NegativenModElements.sounds.get(new ResourceLocation("negativen:n-music_8bit")),
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
