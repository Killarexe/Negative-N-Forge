
package net.killarexe.negativen.block;

import net.minecraft.block.material.Material;

@NegativeNModElements.ModElement.Tag
public class QuartzNBricksBlock extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:quartz_n_bricks")
	public static final Block block = null;

	public QuartzNBricksBlock(NegativeNModElements instance) {
		super(instance, 262);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.9999999999999998f, 10f)
							.setLightLevel(s -> 0).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("quartz_n_bricks");
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
