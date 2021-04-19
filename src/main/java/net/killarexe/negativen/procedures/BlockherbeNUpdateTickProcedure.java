package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.killarexe.negativen.block.TerreNBlock;
import net.killarexe.negativen.block.BlockherbeNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class BlockherbeNUpdateTickProcedure extends NegativeNModElements.ModElement {
	public BlockherbeNUpdateTickProcedure(NegativeNModElements instance) {
		super(instance, 591);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure BlockherbeNUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure BlockherbeNUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure BlockherbeNUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure BlockherbeNUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockherbeNBlock.block.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = TerreNBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockherbeNBlock.block.getDefaultState()
				.getBlock())) {
			sx = (double) (-3);
			found = (boolean) (false);
			for (int index0 = 0; index0 < (int) (6); index0++) {
				sy = (double) (-3);
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sz = (double) (-3);
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))))).getBlock() == Blocks.DIRT
								.getDefaultState().getBlock())) {
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (true))) {
				world.setBlockState(new BlockPos((int) (y + (sy)), (int) (x + (sx)), (int) (z + (sz))), TerreNBlock.block.getDefaultState(), 3);
			}
		}
	}
}
