package net.killarexe.negativen.procedures;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class ClassicNethersCanTravelProcedure extends NegativeNModElements.ModElement {
	public ClassicNethersCanTravelProcedure(NegativeNModElements instance) {
		super(instance, 828);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return ((NegativeNModVariables.IsHalloween) == (true));
	}
}
