package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class SoulSandEntityWalksOnTheBlockProcedure extends NegativeNModElements.ModElement {

	public SoulSandEntityWalksOnTheBlockProcedure(NegativeNModElements instance) {
		super(instance, 697);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure SoulSandEntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 1, (false), (false)));

	}

}
