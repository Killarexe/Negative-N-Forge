package net.killarexe.negativen.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.entity.ZombieNEntity;
import net.killarexe.negativen.entity.SpiderNEntity;
import net.killarexe.negativen.entity.EndermanNEntity;
import net.killarexe.negativen.entity.CreeperNEntity;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class SpawnerNUpdateTickProcedure extends NegativeNModElements.ModElement {
	public SpawnerNUpdateTickProcedure(NegativeNModElements instance) {
		super(instance, 778);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure SpawnerNUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 10, 0.5, 0.5, 0.5, 0.1);
		}
		if ((((world.getLight(new BlockPos((int) (x + 1), (int) y, (int) z))) <= 7)
				&& (((world.getLight(new BlockPos((int) (x - 1), (int) y, (int) z))) <= 7)
						&& (((world.getLight(new BlockPos((int) x, (int) y, (int) (z + 1)))) <= 7)
								&& (((world.getLight(new BlockPos((int) x, (int) y, (int) (z - 1)))) <= 7)
										&& (((world.getLight(new BlockPos((int) (x + 2), (int) y, (int) z))) <= 7)
												&& (((world.getLight(new BlockPos((int) (x - 2), (int) y, (int) z))) <= 7)
														&& (((world.getLight(new BlockPos((int) x, (int) y, (int) (z + 2)))) <= 7)
																&& ((world.getLight(new BlockPos((int) x, (int) y, (int) (z - 2)))) <= 7))))))))) {
			if ((((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new ZombieNEntity.CustomEntity(ZombieNEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles((x + 2), y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new CreeperNEntity.CustomEntity(CreeperNEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles((x - 2), y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new SpiderNEntity.CustomEntity(SpiderNEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, (z + 2), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new EndermanNEntity.CustomEntity(EndermanNEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
