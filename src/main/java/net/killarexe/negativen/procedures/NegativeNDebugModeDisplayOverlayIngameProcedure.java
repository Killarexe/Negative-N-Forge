package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class NegativeNDebugModeDisplayOverlayIngameProcedure extends NegativenModElements.ModElement {
	public NegativeNDebugModeDisplayOverlayIngameProcedure(NegativenModElements instance) {
		super(instance, 479);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NegativeNDebugModeDisplayOverlayIngame!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (((NegativenModVariables.MapVariables.get(world).Debug) == (true)) && ((NegativenModVariables.DevVerson) == (false)));
	}
}
