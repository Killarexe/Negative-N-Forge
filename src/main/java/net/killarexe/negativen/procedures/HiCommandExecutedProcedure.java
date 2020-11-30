package net.killarexe.negativen.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;

import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class HiCommandExecutedProcedure extends NegativenModElements.ModElement {
	public HiCommandExecutedProcedure(NegativenModElements instance) {
		super(instance, 666);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("<Killar.exe> Hi!"));
		}
	}
}
