package net.killarexe.negativen.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class StartanewworldProcedure extends NegativeNModElements.ModElement {
	public StartanewworldProcedure(NegativeNModElements instance) {
		super(instance, 423);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure Startanewworld!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure Startanewworld!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure Startanewworld!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure Startanewworld!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure Startanewworld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("negative_n:wtnn")))
						.isDone()
				: false)) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/give @p written_book{pages:['[\"\",{\"text\":\"Negative-N Guide Book\",\"color\":\"red\"},{\"text\":\"\\\\n\\\\n2-3 Get Started\\\\n4- \\\\u0020Ores\\\\n - \\\\u0020Biomes & Dimensions\\\\n - \\\\u0020Blocks Propreties\\\\n - \\\\u0020Items Propreties\\\\n - \\\\u0020Mobs\\\\n - \\\\u0020Foods\",\"color\":\"reset\"}]','{\"text\":\"1. Get Started\\\\n\\\\nNegative-N Have Multiple\\\\nFeatures! So You Need This Book To Understand Important Features!\\\\n\\\\nFirst The Only Negative-N Items You Can Get In The Overworld Will Be The Principals Materials\"}','[\"\",{\"text\":\"And The Principals Materials Is The Ores! To Advance In The Mod You Will Need \"},{\"text\":\"Ores\",\"color\":\"blue\"},{\"text\":\"!\\\\n\\\\nWith The Ores You Will Get Armors, Tools, Weapons, Etc...\\\\n\\\\nSo Don\\'t Try To Skip Some Ores!\",\"color\":\"black\"}]','{\"text\":\"2. Ores\\\\n\\\\nIn Negative-N They Are 7 Types Of Ores:\\\\n\\\\nCoal-N\\\\nIron-N\\\\nCopper-N\\\\nRedstone-N\\\\nDiamond-N\\\\nGold-N\\\\nEmerald-N\\\\nLapis-N\"}','{\"text\":\"\"}'],title:\"Negative-N Guide\",author:\"N-Dev\",generation:3,display:{Lore:[\"Negative-N Guide Book\",\"Don't Lost It!\"]}}");
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
