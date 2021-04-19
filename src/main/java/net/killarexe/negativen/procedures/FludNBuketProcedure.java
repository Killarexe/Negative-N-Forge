package net.killarexe.negativen.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.potion.UnstablePotion;
import net.killarexe.negativen.block.WaterNBlock;
import net.killarexe.negativen.block.LavaNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class FludNBuketProcedure extends NegativeNModElements.ModElement {
	public FludNBuketProcedure(NegativeNModElements instance) {
		super(instance, 555);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure FludNBuket!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(LavaNBlock.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(UnstablePotion.potion, (int) 60, (int) 1));
		}
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(WaterNBlock.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(UnstablePotion.potion, (int) 60, (int) 1));
		}
	}
}
