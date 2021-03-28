package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class FireNEntityWalksOnTheBlockProcedure extends NegativeNModElements.ModElement {

	public FireNEntityWalksOnTheBlockProcedure(NegativeNModElements instance) {
		super(instance, 597);

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
