package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class DebugModeOnKeyPressedProcedure extends NegativenModElements.ModElement {
	public DebugModeOnKeyPressedProcedure(NegativenModElements instance) {
		super(instance, 374);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DebugModeOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DebugModeOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((NegativenModVariables.MapVariables.get(world).Debug) == (true))) {
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Debug Mode desactivate Sucessfuly!"), (true));
				}
				NegativenModVariables.MapVariables.get(world).Debug = (boolean) (false);
				NegativenModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You are not in Creative Mod!"), (true));
				}
			}
		} else if (((NegativenModVariables.MapVariables.get(world).Debug) == (false))) {
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Debug Mode Activate Sucessfuly!"), (true));
				}
				NegativenModVariables.MapVariables.get(world).Debug = (boolean) (true);
				NegativenModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You are not in Creative Mod!"), (true));
				}
			}
		}
	}
}
