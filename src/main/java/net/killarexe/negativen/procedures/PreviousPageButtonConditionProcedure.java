package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class PreviousPageButtonConditionProcedure extends NegativeNModElements.ModElement {
	public PreviousPageButtonConditionProcedure(NegativeNModElements instance) {
		super(instance, 1029);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure PreviousPageButtonCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) == 1)) {
			return (true);
		}
		return (false);
	}
}
