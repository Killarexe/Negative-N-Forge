package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class PorkchoprawNFoodEatenProcedure extends NegativeNModElements.ModElement {

	public PorkchoprawNFoodEatenProcedure(NegativeNModElements instance) {
		super(instance, 420);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure PorkchoprawNFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 15, (int) 1));

	}

}
