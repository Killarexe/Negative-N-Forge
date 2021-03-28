package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class ArnurendiamantinverseBootsTickEventProcedure extends NegativeNModElements.ModElement {

	public ArnurendiamantinverseBootsTickEventProcedure(NegativeNModElements instance) {
		super(instance, 407);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure ArnurendiamantinverseBootsTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		double random = 0;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 1));

	}

}
