package net.killarexe.negativen.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.killarexe.negativen.item.SugarCaneNItem;
import net.killarexe.negativen.block.NegativecaneBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class SugarCaneNRightClickedOnBlockProcedure extends NegativeNModElements.ModElement {
	public SugarCaneNRightClickedOnBlockProcedure(NegativeNModElements instance) {
		super(instance, 739);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure SugarCaneNRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure SugarCaneNRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure SugarCaneNRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure SugarCaneNRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure SugarCaneNRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), NegativecaneBlock.block.getDefaultState(), 3);
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(SugarCaneNItem.block, (int) (1));
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
