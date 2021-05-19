package net.killarexe.negativen.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.item.RawIronNItem;
import net.killarexe.negativen.item.RawGoldNItem;
import net.killarexe.negativen.item.RawCopperNItem;
import net.killarexe.negativen.item.NegativeDustItem;
import net.killarexe.negativen.item.Iron_NIngotItem;
import net.killarexe.negativen.item.GoldNIngotItem;
import net.killarexe.negativen.item.CopperNIngotItem;
import net.killarexe.negativen.NegativeNModVariables;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class RawIronNGuideProcedure extends NegativeNModElements.ModElement {
	public RawIronNGuideProcedure(NegativeNModElements instance) {
		super(instance, 1073);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure RawIronNGuide!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(NegativeDustItem.block, (int) (1));
			final int _sltid = (int) (1);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(CopperNIngotItem.block, (int) (1));
			final int _sltid = (int) (2);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(Iron_NIngotItem.block, (int) (1));
			final int _sltid = (int) (3);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		{
			ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(GoldNIngotItem.block, (int) (1));
			final int _sltid = (int) (4);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
		if ((((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) == 1)) {
			{
				ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				final ItemStack _setstack = new ItemStack(RawIronNItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceIron", "100%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceCopper", "25%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceGold", "10%");
		} else if ((((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) == 2)) {
			{
				ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				final ItemStack _setstack = new ItemStack(RawCopperNItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceIron", "25%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceCopper", "100%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceGold", "10%");
		} else if ((((entity.getCapability(NegativeNModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NegativeNModVariables.PlayerVariables())).pageNumber) == 3)) {
			{
				ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				final ItemStack _setstack = new ItemStack(RawGoldNItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceIron", "25%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceCopper", "10%");
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putString("chanceGold", "100%");
		}
	}
}
