package net.killarexe.negativen.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.potion.OnFireNPotion;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class FireNEntityWalksOnTheBlockProcedure extends NegativeNModElements.ModElement {
	public FireNEntityWalksOnTheBlockProcedure(NegativeNModElements instance) {
		super(instance, 640);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure FireNEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(OnFireNPotion.potion, (int) 60, (int) 1));
	}
}
