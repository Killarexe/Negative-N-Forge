package net.killarexe.negativen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.lwjgl.glfw.GLFW;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import java.io.InputStream;
import java.nio.file.Paths;
import net.minecraftforge.fml.loading.FMLPaths;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@NegativeNModElements.ModElement.Tag
public class WindowTitle extends NegativeNModElements.ModElement {

	final MainWindow window = Minecraft.getInstance().getMainWindow();
	final Minecraft minecraft = Minecraft.getInstance();
	Logger LOGGER = LogManager.getLogger();

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

	public String title(){
		StringBuilder stringbuilder = new StringBuilder("Negative-N");
      	if (minecraft.isModdedClient()) {
        	 stringbuilder.append("*");
      	}

      	stringbuilder.append(" ");
      	stringbuilder.append(NegativeNModVariables.Version);
      	ClientPlayNetHandler clientplaynethandler = minecraft.getConnection();
      	if (clientplaynethandler != null && clientplaynethandler.getNetworkManager().isChannelOpen()) {
         	stringbuilder.append(" || ");
         	if (minecraft.getIntegratedServer() != null && !minecraft.getIntegratedServer().getPublic()) {
            	stringbuilder.append(I18n.format("Solo"));
         	} else if (minecraft.isConnectedToRealms()) {
            	stringbuilder.append(I18n.format("Multiplayer Relams"));
         	} else if (minecraft.getIntegratedServer() == null && (minecraft.getCurrentServerData() == null || !minecraft.getCurrentServerData().isOnLAN())) {
            	stringbuilder.append(I18n.format("Multiplayer"));
         	} else {
            	stringbuilder.append(I18n.format("Multiplayer LAN"));
         	}
      }

      return stringbuilder.toString();
	}
	
	
	public void updateTitle(){
		window.setWindowTitle(title());
	}
}
