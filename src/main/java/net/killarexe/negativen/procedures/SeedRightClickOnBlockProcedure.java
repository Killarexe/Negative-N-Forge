package net.killarexe.negativen.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.killarexe.negativen.item.WheatNSeedItem;
import net.killarexe.negativen.item.SweetBerryNItem;
import net.killarexe.negativen.item.PotatoNItem;
import net.killarexe.negativen.item.NetherWartNItem;
import net.killarexe.negativen.item.CarrotsNItem;
import net.killarexe.negativen.item.BeetrootSeedItem;
import net.killarexe.negativen.block.WheatNStage0Block;
import net.killarexe.negativen.block.TerreNBlock;
import net.killarexe.negativen.block.SweetBerryNBushStage0Block;
import net.killarexe.negativen.block.SoulSoilNBlock;
import net.killarexe.negativen.block.SoulSandBlock;
import net.killarexe.negativen.block.PotatoNStage0Block;
import net.killarexe.negativen.block.NetherWartNStage0Block;
import net.killarexe.negativen.block.FarmlandNMoistBlock;
import net.killarexe.negativen.block.FarmlandNBlock;
import net.killarexe.negativen.block.CarrotNStage0Block;
import net.killarexe.negativen.block.BlockherbeNBlock;
import net.killarexe.negativen.block.BeetrootsNStage0Block;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;
import java.util.HashMap;

@NegativenModElements.ModElement.Tag
public class SeedRightClickOnBlockProcedure extends NegativenModElements.ModElement {
	public SeedRightClickOnBlockProcedure(NegativenModElements instance) {
		super(instance, 672);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SeedRightClickOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SeedRightClickOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SeedRightClickOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SeedRightClickOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SeedRightClickOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(WheatNSeedItem.block, (int) (1)).getItem())) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNMoistBlock.block.getDefaultState()
							.getBlock()))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), WheatNStage0Block.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(WheatNSeedItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BeetrootSeedItem.block, (int) (1)).getItem())) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNMoistBlock.block.getDefaultState()
							.getBlock()))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BeetrootsNStage0Block.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(BeetrootSeedItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(PotatoNItem.block, (int) (1)).getItem())) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNMoistBlock.block.getDefaultState()
							.getBlock()))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PotatoNStage0Block.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(PotatoNItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(CarrotsNItem.block, (int) (1)).getItem())) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FarmlandNMoistBlock.block.getDefaultState()
							.getBlock()))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CarrotNStage0Block.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(CarrotsNItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(NetherWartNItem.block, (int) (1)).getItem())) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SoulSandBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SoulSoilNBlock.block.getDefaultState()
							.getBlock()))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), NetherWartNStage0Block.block.getDefaultState(), 3);
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(NetherWartNItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SweetBerryNItem.block, (int) (1)).getItem())) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockherbeNBlock.block.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == TerreNBlock.block.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SweetBerryNBushStage0Block.block.getDefaultState(), 3);
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
							.getValue(new ResourceLocation("block.sweet_berry_bush.place")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("block.sweet_berry_bush.place")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if ((new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory
								.clearMatchingItems(p -> new ItemStack(SweetBerryNItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
				}
			}
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand())
			return;
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
