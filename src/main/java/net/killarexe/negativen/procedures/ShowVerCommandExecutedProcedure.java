package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class ShowVerCommandExecutedProcedure extends NegativenModElements.ModElement {
	public ShowVerCommandExecutedProcedure(NegativenModElements instance) {
		super(instance, 669);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ShowVerCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).ShowVersion) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ShowVersion = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(NegativenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativenModVariables.PlayerVariables())).ShowVersion) == (false))) {
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
