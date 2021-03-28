package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class FireNRegenDisplayOverlayIngameProcedure extends NegativeNModElements.ModElement {

	public FireNRegenDisplayOverlayIngameProcedure(NegativeNModElements instance) {
		super(instance, 925);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure FireNRegenDisplayOverlayIngame!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		return ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == OnFireNPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) == (true));

	}

}
