package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.item.ShearsNItem;
import net.killarexe.negativen.block.TorchNState2Block;
import net.killarexe.negativen.block.PumpkinNBlock;
import net.killarexe.negativen.block.JackOLanternNBlock;
import net.killarexe.negativen.block.CarvedPumpkinNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class PumpkinsNRightClickProcedure extends NegativeNModElements.ModElement {
	public PumpkinsNRightClickProcedure(NegativeNModElements instance) {
		super(instance, 832);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure PumpkinsNRightClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure PumpkinsNRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure PumpkinsNRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure PumpkinsNRightClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure PumpkinsNRightClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ShearsNItem.block, (int) (1)).getItem())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PumpkinNBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CarvedPumpkinNBlock.block.getDefaultState(), 3);
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TorchNState2Block.block, (int) (1)).getItem())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CarvedPumpkinNBlock.block.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JackOLanternNBlock.block.getDefaultState(), 3);
			}
		}
	}
}
