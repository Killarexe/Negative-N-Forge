
package net.killarexe.negativen.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

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
public class BeeHiveNHoneyBlock extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:bee_hive_n_honey")
	public static final Block block = null;
	public BeeHiveNHoneyBlock(NegativeNModElements instance) {
		super(instance, 734);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.1500000000000001f, 10f).setLightLevel(s -> 0)
					.harvestLevel(1).harvestTool(ToolType.AXE).setRequiresTool().setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("bee_hive_n_honey");
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
