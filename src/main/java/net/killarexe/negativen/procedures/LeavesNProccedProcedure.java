package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class LeavesNProccedProcedure extends NegativeNModElements.ModElement {

	public LeavesNProccedProcedure(NegativeNModElements instance) {
		super(instance, 568);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure LeavesNProcced!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure LeavesNProcced!");
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
