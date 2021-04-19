package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class OverlayCommandExecutedProcedure extends NegativeNModElements.ModElement {
	public OverlayCommandExecutedProcedure(NegativeNModElements instance) {
		super(instance, 992);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure OverlayCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				NegativeNMod.LOGGER.warn("Failed to load dependency cmdparams for procedure OverlayCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("true"))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.versionOverlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("false"))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.versionOverlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
