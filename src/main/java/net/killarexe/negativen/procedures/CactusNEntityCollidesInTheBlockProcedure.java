package net.killarexe.negativen.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class CactusNEntityCollidesInTheBlockProcedure extends NegativenModElements.ModElement {
	public CactusNEntityCollidesInTheBlockProcedure(NegativenModElements instance) {
		super(instance, 478);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CactusNEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1));
	}
}
