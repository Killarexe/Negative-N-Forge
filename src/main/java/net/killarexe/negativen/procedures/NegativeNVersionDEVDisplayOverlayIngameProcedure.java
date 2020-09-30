package net.killarexe.negativen.procedures;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class NegativeNVersionDEVDisplayOverlayIngameProcedure extends NegativenModElements.ModElement {
	public NegativeNVersionDEVDisplayOverlayIngameProcedure(NegativenModElements instance) {
		super(instance, 477);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return ((NegativenModVariables.DevVerson) == (true));
	}
}
