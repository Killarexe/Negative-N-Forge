package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class WikiCommandExecutedProcedure extends NegativeNModElements.ModElement {

	public WikiCommandExecutedProcedure(NegativeNModElements instance) {
		super(instance, 692);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure WikiCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent("Wiki: https://negativenmod.blogspot.com/p/welcome-to-negative-n-wiki.html"), (false));
		}

	}

}
