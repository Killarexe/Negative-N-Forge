package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class NegativeNVerShowProcedure extends NegativenModElements.ModElement {
	public NegativeNVerShowProcedure(NegativenModElements instance) {
		super(instance, 642);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NegativeNVerShow!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NegativeNVerShow!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		return ((((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).ShowVersion) == (true))
				&& ((NegativenModVariables.MapVariables.get(world).Debug) == (false)));
	}
}
