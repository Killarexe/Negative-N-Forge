package net.killarexe.negativen.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNModVariables;

import java.util.Map;
import java.util.Collections;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@NegativeNModElements.ModElement.Tag
public class WindowUpdateProcedure extends NegativeNModElements.ModElement {

	final MainWindow window = Minecraft.getInstance().getMainWindow();

	public WindowUpdateProcedure(NegativeNModElements instance) {
		super(instance, 1022);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void init(PlayerEvent.PlayerLoggedInEvent event) {
		this.executeProcedure(Collections.emptyMap());
		window.setWindowTitle("Negative-N " + NegativeNModVariables.Version);
	}
}
