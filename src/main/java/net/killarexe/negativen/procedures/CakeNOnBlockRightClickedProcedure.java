package net.killarexe.negativen.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.FoodStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.block.CakeNSlice6Block;
import net.killarexe.negativen.block.CakeNSlice5Block;
import net.killarexe.negativen.block.CakeNSlice4Block;
import net.killarexe.negativen.block.CakeNSlice3Block;
import net.killarexe.negativen.block.CakeNSlice2Block;
import net.killarexe.negativen.block.CakeNSlice1Block;
import net.killarexe.negativen.block.CakeNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class CakeNOnBlockRightClickedProcedure extends NegativeNModElements.ModElement {
	public CakeNOnBlockRightClickedProcedure(NegativeNModElements instance) {
		super(instance, 992);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure CakeNOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure CakeNOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure CakeNOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure CakeNOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure CakeNOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double playerLevel = 0;
		playerLevel = (double) ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0);
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNBlock.block.getDefaultState().getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice1Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice1Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice2Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice2Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice3Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice3Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice4Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice4Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice5Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice5Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CakeNSlice6Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CakeNSlice6Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) (5 + (playerLevel)));
			if (entity instanceof PlayerEntity) {
				ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) (5 + (playerLevel)),
						"field_75125_b");
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
