package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class NegativeNVersionDEVDisplayOverlayIngameProcedure extends NegativenModElements.ModElement {
	public NegativeNVersionDEVDisplayOverlayIngameProcedure(NegativenModElements instance) {
		super(instance, 565);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NegativeNVersionDEVDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).DevVerson) == (true));
	}
}
