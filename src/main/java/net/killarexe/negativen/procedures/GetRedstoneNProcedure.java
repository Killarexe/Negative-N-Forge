package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.killarexe.negativen.block.TNTNBlock;
import net.killarexe.negativen.block.RedstoneLampNOnBlock;
import net.killarexe.negativen.block.RedstoneLampNBlock;
import net.killarexe.negativen.NegativenModElements;
import net.killarexe.negativen.NegativenMod;

import java.util.Map;
import java.util.HashMap;

@NegativenModElements.ModElement.Tag
public class GetRedstoneNProcedure extends NegativenModElements.ModElement {
	public GetRedstoneNProcedure(NegativenModElements instance) {
		super(instance, 722);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativenMod.LOGGER.warn("Failed to load dependency x for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativenMod.LOGGER.warn("Failed to load dependency y for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativenMod.LOGGER.warn("Failed to load dependency z for procedure GetRedstoneN!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativenMod.LOGGER.warn("Failed to load dependency world for procedure GetRedstoneN!");
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
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					TNTNOnBlockRightClickedProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
