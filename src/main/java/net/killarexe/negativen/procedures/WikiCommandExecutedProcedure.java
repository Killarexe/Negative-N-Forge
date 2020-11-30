package net.killarexe.negativen.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class WikiCommandExecutedProcedure extends NegativenModElements.ModElement {
	public WikiCommandExecutedProcedure(NegativenModElements instance) {
		super(instance, 692);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WikiCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent("Wiki: https://negativenmod.blogspot.com/p/welcome-to-negative-n-wiki.html"), (false));
		}
	}
}
