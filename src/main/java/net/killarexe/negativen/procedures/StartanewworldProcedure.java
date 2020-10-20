package net.killarexe.negativen.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.killarexe.negativen.NegativenModVariables;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;

@NegativenModElements.ModElement.Tag
public class StartanewworldProcedure extends NegativenModElements.ModElement {
	public StartanewworldProcedure(NegativenModElements instance) {
		super(instance, 388);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null){
			System.err.println("Failed to load dependency entity for procedure Startanewworld!");
			return;
		}
				Entity entity = (Entity) dependencies.get("entity");


Date special = new Date();
if (((special.getDay())
==31)) {if (((special.getMonth())
==10)) {        NegativenModVariables.IsHalloween =(boolean)(true);
if(entity instanceof ServerPlayerEntity) {
	Advancement _adv = ((MinecraftServer)((ServerPlayerEntity)entity).server).getAdvancementManager()
        .getAdvancement(new ResourceLocation("negativen:happy_halloween"));
    AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
    if (!_ap.isDone()) {
        Iterator _iterator = _ap.getRemaningCriteria().iterator();
        while(_iterator.hasNext()) {
            String _criterion = (String)_iterator.next();
            ((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
        }
    }
}}}else if (((special.getDay())
==(24|25))) {if (((special.getMonth())
==12)) {        NegativenModVariables.IsChistmas =(boolean)(true);
}}else if (((special.getMonth())
==3)) {if (((special.getDay())
==17)) {        NegativenModVariables.IsAnniversary =(boolean)(true);
}}else{        NegativenModVariables.IsAnniversary =(boolean)(false);
        NegativenModVariables.IsHalloween =(boolean)(false);
        NegativenModVariables.IsChistmas =(boolean)(false);
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
