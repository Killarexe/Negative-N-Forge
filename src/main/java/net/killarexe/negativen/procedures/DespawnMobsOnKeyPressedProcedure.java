package net.killarexe.negativen.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class DespawnMobsOnKeyPressedProcedure extends NegativeNModElements.ModElement {
	public DespawnMobsOnKeyPressedProcedure(NegativeNModElements instance) {
		super(instance, 535);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure DespawnMobsOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure DespawnMobsOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure DespawnMobsOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure DespawnMobsOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure DespawnMobsOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((NegativeNModVariables.MapVariables.get(world).Debug) == (true))) {
			if ((entity.hasPermissionLevel((int) 4))) {
				if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"kill @e[type=!player]");
					}
					if (!world.isRemote()) {
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Every Mobs Has been kill"), ChatType.SYSTEM,
									Util.DUMMY_UUID);
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You are Not in creative mod!"), (true));
					}
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Debug Mod is not activate"), (true));
			}
		}
	}
}
