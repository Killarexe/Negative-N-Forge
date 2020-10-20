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
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;

@NegativenModElements.ModElement.Tag
public class SpawnerNUpdateTickProcedure extends NegativenModElements.ModElement {
	public SpawnerNUpdateTickProcedure(NegativenModElements instance) {
		super(instance, 750);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpawnerNUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpawnerNUpdateTick!");
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
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new ZombieNEntity.CustomEntity(ZombieNEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles((x + 2), y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new CreeperNEntity.CustomEntity(CreeperNEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles((x - 2), y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new SpiderNEntity.CustomEntity(SpiderNEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, (z + 2), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new EndermanNEntity.CustomEntity(EndermanNEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
