package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class OnFireNOnPotionActiveTickProcedure extends NegativeNModElements.ModElement {

	public OnFireNOnPotionActiveTickProcedure(NegativeNModElements instance) {
		super(instance, 926);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure OnFireNOnPotionActiveTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 20, (int) 1, (false), (false)));

	}

}
