
package net.killarexe.negativen.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.killarexe.negativen.NegativeNModElements;

import java.util.List;
import java.util.Collections;

@NegativeNModElements.ModElement.Tag
public class GrassBlockCaveGameBlock extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:grass_block_cave_game")
	public static final Block block = null;
	public GrassBlockCaveGameBlock(NegativeNModElements instance) {
		super(instance, 694);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(0f, 0f).setLightLevel(s -> 0));
			setRegistryName("grass_block_cave_game");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
