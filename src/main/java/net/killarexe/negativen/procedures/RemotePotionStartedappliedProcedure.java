package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class RemotePotionStartedappliedProcedure extends NegativeNModElements.ModElement {
	public RemotePotionStartedappliedProcedure(NegativeNModElements instance) {
		super(instance, 1010);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure RemotePotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) (entity.getPosX());
			entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.posX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (entity.getPosY());
			entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.posY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) (entity.getPosZ());
			entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.posZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
