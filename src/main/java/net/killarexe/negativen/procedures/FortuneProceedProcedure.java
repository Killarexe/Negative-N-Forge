package net.killarexe.negativen.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class FortuneProceedProcedure extends NegativeNModElements.ModElement {
	public FortuneProceedProcedure(NegativeNModElements instance) {
		super(instance, 1019);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure FortuneProceed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure FortuneProceed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure FortuneProceed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure FortuneProceed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure FortuneProceed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double Chance = 0;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
				.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))))) {
			if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
				Chance = (double) Math.random();
				for (int index0 = 0; index0 < (int) ((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)))); index0++) {
					if (((Chance) < 0.5)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
									(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
