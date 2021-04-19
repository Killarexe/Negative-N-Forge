package net.killarexe.negativen.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.killarexe.negativen.item.BeetrootsNItem;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class BeetrootStage3BlockDestroyedByPlayerProcedure extends NegativeNModElements.ModElement {
	public BeetrootStage3BlockDestroyedByPlayerProcedure(NegativeNModElements instance) {
		super(instance, 734);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure BeetrootStage3BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure BeetrootStage3BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure BeetrootStage3BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure BeetrootStage3BlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(BeetrootsNItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}
	}
}
