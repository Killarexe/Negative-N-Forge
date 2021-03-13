package net.killarexe.negativen.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.potion.OnFireNPotion;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.Collection;

@NegativeNModElements.ModElement.Tag
public class FireNRegenDisplayOverlayIngameProcedure extends NegativeNModElements.ModElement {
	public FireNRegenDisplayOverlayIngameProcedure(NegativeNModElements instance) {
		super(instance, 925);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure FireNRegenDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == OnFireNPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) == (true));
	}
}
