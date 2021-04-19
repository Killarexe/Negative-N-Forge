package net.killarexe.negativen.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.Collections;

@NegativeNModElements.ModElement.Tag
public class RemotePotionExpiresProcedure extends NegativeNModElements.ModElement {
	public RemotePotionExpiresProcedure(NegativeNModElements instance) {
		super(instance, 1011);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure RemotePotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(
					((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NegativeNModVariables.PlayerVariables())).posX),
					((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NegativeNModVariables.PlayerVariables())).posY),
					((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NegativeNModVariables.PlayerVariables())).posZ));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(
						((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NegativeNModVariables.PlayerVariables())).posX),
						((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NegativeNModVariables.PlayerVariables())).posY),
						((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NegativeNModVariables.PlayerVariables())).posZ),
						_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
