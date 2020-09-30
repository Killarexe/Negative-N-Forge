package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.killarexe.negativen.block.RedstoneLampNOnBlock;
import net.killarexe.negativen.block.RedstoneLampNBlock;
import net.killarexe.negativen.block.RedstoneBlockNBlock;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class GetRedstoneNProcedure extends NegativenModElements.ModElement {
	public GetRedstoneNProcedure(NegativenModElements instance) {
		super(instance, 645);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GetRedstoneN!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RedstoneLampNBlock.block.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == RedstoneBlockNBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNOnBlock.block.getDefaultState(), 3);
			} else if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == RedstoneBlockNBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNOnBlock.block.getDefaultState(), 3);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == RedstoneBlockNBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNOnBlock.block.getDefaultState(), 3);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == RedstoneBlockNBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNOnBlock.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RedstoneLampNOnBlock.block.getDefaultState()
				.getBlock())) {
			if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == RedstoneBlockNBlock.block.getDefaultState()
					.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNBlock.block.getDefaultState(), 3);
			} else if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == RedstoneBlockNBlock.block
					.getDefaultState().getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNBlock.block.getDefaultState(), 3);
			} else if ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == RedstoneBlockNBlock.block
					.getDefaultState().getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNBlock.block.getDefaultState(), 3);
			} else if ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == RedstoneBlockNBlock.block
					.getDefaultState().getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNBlock.block.getDefaultState(), 3);
			}
		}
	}
}
