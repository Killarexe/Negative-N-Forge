package net.killarexe.negativen.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class UnstablePotionStartedappliedProcedure extends NegativeNModElements.ModElement {
	public UnstablePotionStartedappliedProcedure(NegativeNModElements instance) {
		super(instance, 504);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure UnstablePotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		for (int index0 = 0; index0 < (int) (10); index0++) {
			entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
		}
	}
}
