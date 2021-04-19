package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.killarexe.negativen.block.BlockherbeNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class SweetBerryNBushStage3AdditionalGenerationConditionProcedure extends NegativeNModElements.ModElement {
	public SweetBerryNBushStage3AdditionalGenerationConditionProcedure(NegativeNModElements instance) {
		super(instance, 801);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure SweetBerryNBushStage3AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure SweetBerryNBushStage3AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure SweetBerryNBushStage3AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure SweetBerryNBushStage3AdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockherbeNBlock.block.getDefaultState()
				.getBlock()) == (true));
	}
}
