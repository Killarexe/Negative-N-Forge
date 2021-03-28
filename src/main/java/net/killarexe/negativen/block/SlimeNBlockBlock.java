
package net.killarexe.negativen.block;

import net.minecraft.block.material.Material;

@NegativeNModElements.ModElement.Tag
public class SlimeNBlockBlock extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:slime_n_block")
	public static final Block block = null;

	public SlimeNBlockBlock(NegativeNModElements instance) {
		super(instance, 235);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(NegativeNBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.SEA_GRASS).sound(SoundType.SLIME).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0)
							.slipperiness(0.3f).setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));

			setRegistryName("slime_n_block");
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
