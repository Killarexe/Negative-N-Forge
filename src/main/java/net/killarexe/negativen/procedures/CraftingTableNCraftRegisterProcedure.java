package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class CraftingTableNCraftRegisterProcedure extends NegativeNModElements.ModElement {
	public CraftingTableNCraftRegisterProcedure(NegativeNModElements instance) {
		super(instance, 980);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure CraftingTableNCraftRegister!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure CraftingTableNCraftRegister!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure CraftingTableNCraftRegister!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure CraftingTableNCraftRegister!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			MiningCraftProcedure.executeProcedure($_dependencies);
		}
	}
}
