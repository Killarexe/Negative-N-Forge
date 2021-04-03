package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.item.WheatNSeedItem;
import net.killarexe.negativen.block.WheatNStage0Block;
import net.killarexe.negativen.block.FarmlandNMoistBlock;
import net.killarexe.negativen.block.FarmlandNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class WheatNSeedRightClickedOnBlockProcedure extends NegativeNModElements.ModElement {
	public WheatNSeedRightClickedOnBlockProcedure(NegativeNModElements instance) {
		super(instance, 681);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure WheatNSeedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure WheatNSeedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure WheatNSeedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure WheatNSeedRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure WheatNSeedRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNMoistBlock.block.getDefaultState()
						.getBlock()))
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), WheatNStage0Block.block.getDefaultState(), 3);
			if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(WheatNSeedItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
		}
	}
}
