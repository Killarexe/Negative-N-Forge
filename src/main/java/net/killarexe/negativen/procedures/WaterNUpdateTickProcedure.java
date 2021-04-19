package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;

import net.killarexe.negativen.block.BlueIceNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class WaterNUpdateTickProcedure extends NegativeNModElements.ModElement {
	public WaterNUpdateTickProcedure(NegativeNModElements instance) {
		super(instance, 948);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure WaterNUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure WaterNUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure WaterNUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure WaterNUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("negative_n:montains_n")))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlueIceNBlock.block.getDefaultState(), 3);
		}
	}
}
