package net.killarexe.negativen.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.Collections;

@NegativeNModElements.ModElement.Tag
public class TeleporterPotionStartedappliedProcedure extends NegativeNModElements.ModElement {
	public TeleporterPotionStartedappliedProcedure(NegativeNModElements instance) {
		super(instance, 1017);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure TeleporterPotionStartedapplied!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure TeleporterPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((Math.random() * 100), y, (Math.random() * 100));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.random() * 100), y, (Math.random() * 100), _ent.rotationYaw,
						_ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
