package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class NextPageButtonConditionProcedure extends NegativeNModElements.ModElement {
	public NextPageButtonConditionProcedure(NegativeNModElements instance) {
		super(instance, 1028);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure NextPageButtonCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((NegativeNModVariables.WorldVariables.get(world).Z) <= 3)) {
			return (true);
		}
		return (false);
	}
}
