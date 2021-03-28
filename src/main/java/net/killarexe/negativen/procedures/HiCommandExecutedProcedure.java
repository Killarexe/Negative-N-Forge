package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class HiCommandExecutedProcedure extends NegativeNModElements.ModElement {

	public HiCommandExecutedProcedure(NegativeNModElements instance) {
		super(instance, 666);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure HiCommandExecuted!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");

		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("<Killar.exe> Hi!"), ChatType.SYSTEM, Util.DUMMY_UUID);
		}

	}

}
