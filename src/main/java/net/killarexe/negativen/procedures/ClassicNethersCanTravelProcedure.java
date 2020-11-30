package net.killarexe.negativen.procedures;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class ClassicNethersCanTravelProcedure extends NegativenModElements.ModElement {
	public ClassicNethersCanTravelProcedure(NegativenModElements instance) {
		super(instance, 804);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return ((NegativenModVariables.IsHalloween) == (true));
	}
}
