package net.killarexe.negativen.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

import net.killarexe.negativen.block.SpruceLogNBlock;
import net.killarexe.negativen.block.JungleLogNBlock;
import net.killarexe.negativen.block.DarkOakLogNBlock;
import net.killarexe.negativen.block.BoisNBlock;
import net.killarexe.negativen.block.BirchlognBlock;
import net.killarexe.negativen.block.AcacialognBlock;
import net.killarexe.negativen.NegativenModElements;
import net.killarexe.negativen.NegativenMod;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class LeavesNProccedProcedure extends NegativenModElements.ModElement {
	public LeavesNProccedProcedure(NegativenModElements instance) {
		super(instance, 568);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativenMod.LOGGER.warn("Failed to load dependency x for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativenMod.LOGGER.warn("Failed to load dependency y for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativenMod.LOGGER.warn("Failed to load dependency z for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativenMod.LOGGER.warn("Failed to load dependency world for procedure LeavesNProcced!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double OffX = 0;
		double OffY = 0;
		double OffZ = 0;
		boolean DelayLeaves = false;
		OffX = (double) (-4);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			OffY = (double) (-4);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				OffZ = (double) (-4);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == BoisNBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					} else if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == AcacialognBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					} else if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == BirchlognBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					} else if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == DarkOakLogNBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					} else if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == JungleLogNBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					} else if (((world.getBlockState(new BlockPos((int) (x + (OffX)), (int) (y + (OffY)), (int) (z + (OffZ)))))
							.getBlock() == SpruceLogNBlock.block.getDefaultState().getBlock())) {
						if (world instanceof World) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
									new BlockPos((int) x, (int) y, (int) z));
							world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
						}
					}
					OffX = (double) ((OffX) + 1);
				}
				OffY = (double) ((OffY) + 1);
			}
			OffZ = (double) ((OffZ) + 1);
		}
	}
}
