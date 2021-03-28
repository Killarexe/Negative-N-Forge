package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class DNArmorAProcedure extends NegativeNModElements.ModElement {

	public DNArmorAProcedure(NegativeNModElements instance) {
		super(instance, 583);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure DNArmorA!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) == 10) && (entity instanceof PlayerEntity))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("negative_n:couvremoidenegatf"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}

	}

}
