
package net.killarexe.negativen.block;

import net.minecraft.block.material.Material;

@NegativeNModElements.ModElement.Tag
public class SnowBlockNBlock extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:snow_block_n")
	public static final Block block = null;

	public SnowBlockNBlock(NegativeNModElements instance) {
		super(instance, 213);

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

					Block.Properties.create(Material.SNOW).sound(SoundType.SNOW).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(2)
							.harvestTool(ToolType.SHOVEL).setRequiresTool().tickRandomly());

			setRegistryName("snow_block_n");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				SnowNUpdateTickProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
