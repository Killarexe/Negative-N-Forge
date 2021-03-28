package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class WitherCombatProcedure extends NegativeNModElements.ModElement {

	public WitherCombatProcedure(NegativeNModElements instance) {
		super(instance, 1006);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure WitherCombat!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		return ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getHealth()
				: -1) == (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) / 2)) == (true));

	}

}
