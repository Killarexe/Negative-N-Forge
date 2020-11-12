package net.killarexe.negativen.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class ArnurendiamantinverseBootsTickEventProcedure extends NegativenModElements.ModElement {
	public ArnurendiamantinverseBootsTickEventProcedure(NegativenModElements instance) {
		super(instance, 387);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ArnurendiamantinverseBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 1));
	}
}
