package net.killarexe.negativen.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.potion.UnstablePotion;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.Collection;

@NegativeNModElements.ModElement.Tag
public class AntiBrakingOnPotionActiveTickProcedure extends NegativeNModElements.ModElement {
	public AntiBrakingOnPotionActiveTickProcedure(NegativeNModElements instance) {
		super(instance, 1090);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure AntiBrakingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NegativeNMod.LOGGER.warn("Failed to load dependency itemstack for procedure AntiBrakingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double durabilityBase = 0;
		while (((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == UnstablePotion.potion)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity)) >= 3580)) {
			durabilityBase = (double) (((itemstack)).getDamage());
		}
		if (((durabilityBase) <= (((itemstack)).getDamage()))) {
			((itemstack)).setDamage((int) (durabilityBase));
		}
	}
}
