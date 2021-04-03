package net.killarexe.negativen.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.killarexe.negativen.enchantment.WitheredEnchantment;
import net.killarexe.negativen.enchantment.PoisonusEnchantment;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class PoisonusProccedProcedure extends NegativeNModElements.ModElement {
	public PoisonusProccedProcedure(NegativeNModElements instance) {
		super(instance, 665);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonusProcced!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PoisonusProcced!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double EnchantLevel = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(PoisonusEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			EnchantLevel = (double) (EnchantmentHelper.getEnchantmentLevel(PoisonusEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)));
		} else if (((EnchantmentHelper.getEnchantmentLevel(WitheredEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			EnchantLevel = (double) (EnchantmentHelper.getEnchantmentLevel(PoisonusEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(PoisonusEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 256, (int) (EnchantLevel)));
		} else if (((EnchantmentHelper.getEnchantmentLevel(PoisonusEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 256, (int) (EnchantLevel)));
		} else if (((EnchantmentHelper.getEnchantmentLevel(WitheredEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 256, (int) (EnchantLevel)));
		} else if (((EnchantmentHelper.getEnchantmentLevel(WitheredEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 256, (int) (EnchantLevel)));
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
