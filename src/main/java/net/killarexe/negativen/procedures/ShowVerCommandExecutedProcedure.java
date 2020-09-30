package net.killarexe.negativen.procedures;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class ShowVerCommandExecutedProcedure extends NegativenModElements.ModElement {
	public ShowVerCommandExecutedProcedure(NegativenModElements instance) {
		super(instance, 564);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (((NegativenModVariables.ShowVersion) == (true))) {
			NegativenModVariables.ShowVersion = (boolean) (false);
		} else if (((NegativenModVariables.ShowVersion) == (false))) {
			NegativenModVariables.ShowVersion = (boolean) (true);
		}
	}
}
