package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.killarexe.negativen.block.WeatheredCutCopperNStairsBlock;
import net.killarexe.negativen.block.WeatheredCutCopperNSlabBlock;
import net.killarexe.negativen.block.WeatheredCutCopperNBlockBlock;
import net.killarexe.negativen.block.WeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.SemiWeatheredCutCopperNStairsBlock;
import net.killarexe.negativen.block.SemiWeatheredCutCopperNSlabBlock;
import net.killarexe.negativen.block.SemiWeatheredCutCopperNBlockBlock;
import net.killarexe.negativen.block.SemiWeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.LightlyWeatheredCutCopperNStairsBlock;
import net.killarexe.negativen.block.LightlyWeatheredCutCopperNSlabBlock;
import net.killarexe.negativen.block.LightlyWeatheredCutCopperBlockBlock;
import net.killarexe.negativen.block.LightlyWeatheredCopperNBlockBlock;
import net.killarexe.negativen.block.CutCopperNStairsBlock;
import net.killarexe.negativen.block.CutCopperNSlabBlock;
import net.killarexe.negativen.block.CutCopperNBlockBlock;
import net.killarexe.negativen.block.CopperNBlockBlock;
import net.killarexe.negativen.NegativenModElements;
import net.killarexe.negativen.NegativenMod;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class CopperNAgeProcedureProcedure extends NegativenModElements.ModElement {
	public CopperNAgeProcedureProcedure(NegativenModElements instance) {
		super(instance, 825);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativenMod.LOGGER.warn("Failed to load dependency x for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativenMod.LOGGER.warn("Failed to load dependency y for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativenMod.LOGGER.warn("Failed to load dependency z for procedure CopperNAgeProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativenMod.LOGGER.warn("Failed to load dependency world for procedure CopperNAgeProcedure!");
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
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CutCopperNSlabBlock.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyWeatheredCutCopperNSlabBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LightlyWeatheredCutCopperNSlabBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SemiWeatheredCutCopperNSlabBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SemiWeatheredCutCopperNSlabBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeatheredCutCopperNSlabBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CutCopperNStairsBlock.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyWeatheredCutCopperNStairsBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LightlyWeatheredCutCopperNStairsBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SemiWeatheredCutCopperNStairsBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SemiWeatheredCutCopperNStairsBlock.block
				.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeatheredCutCopperNStairsBlock.block.getDefaultState(), 3);
		}
	}
}
