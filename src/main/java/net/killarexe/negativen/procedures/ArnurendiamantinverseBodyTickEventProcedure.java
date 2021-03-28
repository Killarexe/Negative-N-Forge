package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class ArnurendiamantinverseBodyTickEventProcedure extends NegativeNModElements.ModElement {

	public ArnurendiamantinverseBodyTickEventProcedure(NegativeNModElements instance) {
		super(instance, 652);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure ArnurendiamantinverseBodyTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 1));

	}

}
