package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class DeepslateNDiamondNOreUpdateTickProcedure extends NegativeNModElements.ModElement {

	public DeepslateNDiamondNOreUpdateTickProcedure(NegativeNModElements instance) {
		super(instance, 1019);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure DeepslateNDiamondNOreUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure DeepslateNDiamondNOreUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure DeepslateNDiamondNOreUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure DeepslateNDiamondNOreUpdateTick!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		boolean isAir = false;
		double isTransform = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			isAir = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
				.getBlock())) {
			isAir = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
				.getBlock())) {
			isAir = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
				.getBlock())) {
			isAir = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
				.getBlock())) {
			isAir = (boolean) (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
				.getBlock())) {
			isAir = (boolean) (true);
		}
		if (((isAir) == (true))) {
			isTransform = (double) Math.random();
			if (((isTransform) <= 0.25)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DeepslateNBlock.block.getDefaultState(), 3);
			}
		}

	}

}
