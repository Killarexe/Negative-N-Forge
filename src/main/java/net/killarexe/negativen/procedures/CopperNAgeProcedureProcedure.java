package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.killarexe.negativen.block.WeatheredCutCopperNBlockBlock;
import net.killarexe.negativen.block.WeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.SemiWeatheredCutCopperNBlockBlock;
import net.killarexe.negativen.block.SemiWeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.LightlyWeatheredCutCopperBlockBlock;
import net.killarexe.negativen.block.LightlyWeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.CutCopperNBlockBlock;
import net.killarexe.negativen.block.CopperNBlockBlock;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class CopperNAgeProcedureProcedure extends NegativenModElements.ModElement {
	public CopperNAgeProcedureProcedure(NegativenModElements instance) {
		super(instance, 810);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CopperNAgeProcedure!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CopperNBlockBlock.block.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyWeatheredCopperNBlockBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LightlyWeatheredCopperNBlockBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SemiWeatheredCopperNBlockBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SemiWeatheredCopperNBlockBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeatheredCopperNBlockBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CutCopperNBlockBlock.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyWeatheredCutCopperBlockBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LightlyWeatheredCutCopperBlockBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SemiWeatheredCutCopperNBlockBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SemiWeatheredCutCopperNBlockBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeatheredCutCopperNBlockBlock.block.getDefaultState(), 3);
		}
	}
}
