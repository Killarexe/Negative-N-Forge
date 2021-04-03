package net.killarexe.negativen.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.entity.TntnprimedEntity;
import net.killarexe.negativen.block.TNTNBlock;
import net.killarexe.negativen.block.RedstoneLampNOnBlock;
import net.killarexe.negativen.block.RedstoneLampNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class GetRedstoneNProcedure extends NegativeNModElements.ModElement {
	public GetRedstoneNProcedure(NegativeNModElements instance) {
		super(instance, 722);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure GetRedstoneN!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean isOn = false;
		if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))) {
			isOn = (boolean) (true);
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))) {
			isOn = (boolean) (true);
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))) {
			isOn = (boolean) (true);
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))) {
			isOn = (boolean) (true);
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
			isOn = (boolean) (true);
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:redstone_n").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
			isOn = (boolean) (true);
		} else {
			isOn = (boolean) (false);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RedstoneLampNBlock.block.getDefaultState().getBlock())) {
			if (((isOn) == (true))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNOnBlock.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RedstoneLampNOnBlock.block.getDefaultState()
				.getBlock())) {
			if (((isOn) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneLampNBlock.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == TNTNBlock.block.getDefaultState().getBlock())) {
			if (((isOn) == (true))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new TntnprimedEntity.CustomEntity(TntnprimedEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
