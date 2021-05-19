package net.killarexe.negativen.procedures;

import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class RecipeRawFilterScreenProcedure extends NegativeNModElements.ModElement {
	public RecipeRawFilterScreenProcedure(NegativeNModElements instance) {
		super(instance, 1073);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure RecipeRawFilterScreen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		String pageNumberText = "";
		pageNumberText = (String) (("Page ") + ""
				+ ((new java.text.DecimalFormat("##").format(((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber)))));
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			RawIronNGuideProcedure.executeProcedure($_dependencies);
		}
	}
}
