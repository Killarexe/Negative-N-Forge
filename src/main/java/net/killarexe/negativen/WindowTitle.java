package net.killarexe.negativen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@NegativeNModElements.ModElement.Tag
public class WindowTitle extends NegativeNModElements.ModElement {

	final MainWindow window = Minecraft.getInstance().getMainWindow();

	public WindowTitle(NegativeNModElements instance) {
		super(instance, 1003);
	}

	@Override
	public void initElements() {
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		updateTitle();
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
	}
	
	@Override
	public void clientLoad(FMLClientSetupEvent e){
		e.getMinecraftSupplier().get().execute(this::updateTitle);
	}

	
	public void updateTitle(){
		window.setWindowTitle("Negative-N " + NegativeNModVariables.Version);
	}
}
