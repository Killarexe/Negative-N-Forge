package net.killarexe.negativen.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;
import java.util.Iterator;

@NegativenModElements.ModElement.Tag
public class DevShowCommandExecutedProcedure extends NegativenModElements.ModElement {
	public DevShowCommandExecutedProcedure(NegativenModElements instance) {
		super(instance, 567);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DevShowCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).DevVerson) == (false))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DevVerson = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ShowVersion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("negativen:dev_overlay"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).DevVerson) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DevVerson = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ShowVersion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
