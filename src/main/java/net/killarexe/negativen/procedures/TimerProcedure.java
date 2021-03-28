package net.killarexe.negativen.procedures;

@NegativeNModElements.ModElement.Tag
public class TimerProcedure extends NegativeNModElements.ModElement {

	public TimerProcedure(NegativeNModElements instance) {
		super(instance, 429);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {

		NegativeNModVariables.global_timer = (double) ((NegativeNModVariables.global_timer) + 0.05);
		if (((NegativeNModVariables.global_timer) >= 1.1)) {
			NegativeNModVariables.global_timer = (double) 0;
		}

	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			IWorld world = event.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

}
