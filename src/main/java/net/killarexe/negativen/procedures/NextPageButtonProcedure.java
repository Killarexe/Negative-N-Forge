package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class NextPageButtonProcedure extends NegativeNModElements.ModElement {
	public NextPageButtonProcedure(NegativeNModElements instance) {
		super(instance, 1026);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure NextPageButton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) <= 3)) {
			{
				double _setval = (double) (((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) + 1);
				entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.pageNumber = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
