package net.killarexe.negativen.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.potion.TeleporterPotion;
import net.killarexe.negativen.potion.RemotePotion;
import net.killarexe.negativen.potion.OxidationPotion;
import net.killarexe.negativen.potion.FrozenPotion;
import net.killarexe.negativen.potion.AntiBrakingPotion;
import net.killarexe.negativen.item.TeleporterBottleNItem;
import net.killarexe.negativen.item.RemoteBottleNItem;
import net.killarexe.negativen.item.OxidationBottleNItem;
import net.killarexe.negativen.item.FrozenBottleNItem;
import net.killarexe.negativen.item.AntiBrakingBottleNItem;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class PotionsNDrinkProcedure extends NegativeNModElements.ModElement {
	public PotionsNDrinkProcedure(NegativeNModElements instance) {
		super(instance, 1085);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure PotionsNDrink!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(RemoteBottleNItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(RemotePotion.potion, (int) 3600, (int) 1));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TeleporterBottleNItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(TeleporterPotion.potion, (int) 20, (int) 1));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(OxidationBottleNItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(OxidationPotion.potion, (int) 3600, (int) 1));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FrozenBottleNItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(FrozenPotion.potion, (int) 3600, (int) 1));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(AntiBrakingBottleNItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(AntiBrakingPotion.potion, (int) 3600, (int) 1));
		}
	}
}
