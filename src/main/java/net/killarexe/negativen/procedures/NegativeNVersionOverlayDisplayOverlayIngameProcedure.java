package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;

import net.killarexe.negativen.world.ShowVersionGameRule;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class NegativeNVersionOverlayDisplayOverlayIngameProcedure extends NegativeNModElements.ModElement {
	public NegativeNVersionOverlayDisplayOverlayIngameProcedure(NegativeNModElements instance) {
		super(instance, 963);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure NegativeNVersionOverlayDisplayOverlayIngame!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ShowVersionGameRule.gamerule)) == (true))) {
			return (true);
		} else {
			return (false);
		}
		return (false);
	}
}
