package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.block.RoseNBushTopBlock;
import net.killarexe.negativen.block.RoseBushNBottomBlock;
import net.killarexe.negativen.block.PeonyNTopBlock;
import net.killarexe.negativen.block.PeonyNBottomBlock;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class DoubleFlowersBlockAddedProcedure extends NegativenModElements.ModElement {
	public DoubleFlowersBlockAddedProcedure(NegativenModElements instance) {
		super(instance, 765);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DoubleFlowersBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DoubleFlowersBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DoubleFlowersBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DoubleFlowersBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PeonyNBottomBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PeonyNTopBlock.block.getDefaultState(), 3);
			} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RoseBushNBottomBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), RoseNBushTopBlock.block.getDefaultState(), 3);
			}
		}
	}
}
