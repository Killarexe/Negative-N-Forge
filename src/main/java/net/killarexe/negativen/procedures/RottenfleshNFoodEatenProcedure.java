package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class RottenfleshNFoodEatenProcedure extends NegativeNModElements.ModElement {

	public RottenfleshNFoodEatenProcedure(NegativeNModElements instance) {
		super(instance, 413);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure RottenfleshNFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 60, (int) 1));

	}

}
