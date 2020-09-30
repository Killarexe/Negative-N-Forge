package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;

import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class PeonyNBottomParticleSpawningConditionProcedure extends NegativenModElements.ModElement {
	public PeonyNBottomParticleSpawningConditionProcedure(NegativenModElements instance) {
		super(instance, 731);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PeonyNBottomParticleSpawningCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (!(world.getWorld().isDaytime()));
	}
}
