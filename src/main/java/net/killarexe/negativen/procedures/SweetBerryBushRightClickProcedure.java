package net.killarexe.negativen.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.killarexe.negativen.item.SweetBerryNItem;
import net.killarexe.negativen.block.SweetBerryNBushStage3Block;
import net.killarexe.negativen.block.SweetBerryNBushStage2Block;
import net.killarexe.negativen.block.SweetBerryNBushStage1Block;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class SweetBerryBushRightClickProcedure extends NegativeNModElements.ModElement {
	public SweetBerryBushRightClickProcedure(NegativeNModElements instance) {
		super(instance, 810);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure SweetBerryBushRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure SweetBerryBushRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure SweetBerryBushRightClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure SweetBerryBushRightClick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SweetBerryNBushStage2Block.block.getDefaultState()
				.getBlock())) {
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			for (int index0 = 0; index0 < (int) (2); index0++) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SweetBerryNItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage1Block.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SweetBerryNBushStage3Block.block.getDefaultState()
				.getBlock())) {
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("item.sweet_berries.pick_from_bush")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			for (int index1 = 0; index1 < (int) (3); index1++) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SweetBerryNItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SweetBerryNBushStage1Block.block.getDefaultState(), 3);
		}
	}
}
