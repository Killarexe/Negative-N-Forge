package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.block.WheatNStage7Block;
import net.killarexe.negativen.block.WheatNStage6Block;
import net.killarexe.negativen.block.WheatNStage5Block;
import net.killarexe.negativen.block.WheatNStage4Block;
import net.killarexe.negativen.block.WheatNStage3Block;
import net.killarexe.negativen.block.WheatNStage2Block;
import net.killarexe.negativen.block.WheatNStage1Block;
import net.killarexe.negativen.block.WheatNStage0Block;
import net.killarexe.negativen.block.SweetBerryNBushStage3Block;
import net.killarexe.negativen.block.SweetBerryNBushStage2Block;
import net.killarexe.negativen.block.SweetBerryNBushStage1Block;
import net.killarexe.negativen.block.SweetBerryNBushStage0Block;
import net.killarexe.negativen.block.PotatoStage3Block;
import net.killarexe.negativen.block.PotatoStage2Block;
import net.killarexe.negativen.block.PotatoNStage1Block;
import net.killarexe.negativen.block.PotatoNStage0Block;
import net.killarexe.negativen.block.NetherWartNStage2Block;
import net.killarexe.negativen.block.NetherWartNStage1Block;
import net.killarexe.negativen.block.NetherWartNStage0Block;
import net.killarexe.negativen.block.CarrotNStage3Block;
import net.killarexe.negativen.block.CarrotNStage2Block;
import net.killarexe.negativen.block.CarrotNStage1Block;
import net.killarexe.negativen.block.CarrotNStage0Block;
import net.killarexe.negativen.block.BeetrootsStage2Block;
import net.killarexe.negativen.block.BeetrootsStage1Block;
import net.killarexe.negativen.block.BeetrootsNStage0Block;
import net.killarexe.negativen.block.BeetrootStage3Block;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class CropsGrowProcedure extends NegativeNModElements.ModElement {
	public CropsGrowProcedure(NegativeNModElements instance) {
		super(instance, 726);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure CropsGrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure CropsGrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure CropsGrow!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure CropsGrow!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double RandomGroth = 0;
		RandomGroth = (double) Math.random();
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage0Block.block.getDefaultState().getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage3Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage2Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage2Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage4Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage3Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage3Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage5Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage4Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage4Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage6Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage5Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage5Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage7Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage6Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WheatNStage6Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WheatNStage7Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BeetrootsNStage0Block.block.getDefaultState().getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BeetrootsStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BeetrootsStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BeetrootsStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BeetrootStage3Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BeetrootsStage2Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BeetrootsStage2Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BeetrootStage3Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CarrotNStage0Block.block.getDefaultState().getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarrotNStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarrotNStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CarrotNStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarrotNStage3Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarrotNStage2Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CarrotNStage2Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarrotNStage3Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PotatoNStage0Block.block.getDefaultState().getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PotatoStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PotatoNStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PotatoNStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PotatoStage3Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PotatoStage2Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PotatoStage2Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PotatoStage3Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NetherWartNStage0Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NetherWartNStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NetherWartNStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NetherWartNStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NetherWartNStage2Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SweetBerryNBushStage0Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage2Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage1Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SweetBerryNBushStage1Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.66)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage3Block.block.getDefaultState(), 3);
			} else if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage2Block.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SweetBerryNBushStage2Block.block.getDefaultState()
				.getBlock())) {
			if (((RandomGroth) <= 0.33)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage3Block.block.getDefaultState(), 3);
			}
		}
	}
}
