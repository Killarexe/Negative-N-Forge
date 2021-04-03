
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.killarexe.negativen.itemgroup.NegativeNRessouresItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class BadAppleClassicItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:bad_apple_classic")
	public static final Item block = null;
	public BadAppleClassicItem(NegativeNModElements instance) {
		super(instance, 1012);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NegativeNModElements.sounds.get(new ResourceLocation("negative_n:op")),
					new Item.Properties().group(NegativeNRessouresItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bad_apple_classic");
		}
	}
}
