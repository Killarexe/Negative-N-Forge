
package net.killarexe.negativen.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.killarexe.negativen.procedures.VineNUpdateTickProcedure;
import net.killarexe.negativen.itemgroup.NegativeNDecorationBlocksItemGroup;
import net.killarexe.negativen.NegativeNModElements;

import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@NegativeNModElements.ModElement.Tag
public class VineNBlock extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:vine_n")
	public static final Block block = null;
	public VineNBlock(NegativeNModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(NegativeNDecorationBlocksItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.5f, 10f).setLightLevel(s -> 0)
					.doesNotBlockMovement().notSolid().tickRandomly().setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("vine_n");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.GRASS;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
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
				VineNUpdateTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
