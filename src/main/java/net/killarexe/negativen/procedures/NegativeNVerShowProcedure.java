package net.killarexe.negativen.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.killarexe.negativen.world.ShowversionGameRule;
import net.killarexe.negativen.world.DebugModeNGameRule;
import net.killarexe.negativen.NegativenModElements;
import net.killarexe.negativen.NegativenMod;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class NegativeNVerShowProcedure extends NegativenModElements.ModElement {
	public NegativeNVerShowProcedure(NegativenModElements instance) {
		super(instance, 671);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativenMod.LOGGER.warn("Failed to load dependency world for procedure NegativeNVerShow!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return ((((world instanceof World) ? ((World) world).getGameRules().getBoolean(ShowversionGameRule.gamerule) : false) == (true))
				&& (((world instanceof World) ? ((World) world).getGameRules().getBoolean(DebugModeNGameRule.gamerule) : false) == (false)));
	}
}
