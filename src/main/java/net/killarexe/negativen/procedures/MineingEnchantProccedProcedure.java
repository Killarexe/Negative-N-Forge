package net.killarexe.negativen.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.killarexe.negativen.enchantment.MineingEnchantment;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class MineingEnchantProccedProcedure extends NegativeNModElements.ModElement {
	public MineingEnchantProccedProcedure(NegativeNModElements instance) {
		super(instance, 885);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure MineingEnchantProcced!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure MineingEnchantProcced!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure MineingEnchantProcced!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure MineingEnchantProcced!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure MineingEnchantProcced!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(MineingEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() instanceof PickaxeItem)) {
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
						&& (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.ROCK) == (true))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.IRON) == (true))
										|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
												.getMaterial() == net.minecraft.block.material.Material.ANVIL) == (true))
												|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
														.getMaterial() == net.minecraft.block.material.Material.ICE) == (true))
														|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																.getMaterial() == net.minecraft.block.material.Material.PACKED_ICE) == (true))
																|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																		.getMaterial() == net.minecraft.block.material.Material.SHULKER) == (true))
																		|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																				.getMaterial() == net.minecraft.block.material.Material.PISTON) == (true))))))))
								&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
										.getBlock()))))) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					posX = (double) (x - 1);
					posY = (double) (y - 1);
					posZ = (double) (z - 1);
					for (int index0 = 0; index0 < (int) (3); index0++) {
						for (int index1 = 0; index1 < (int) (3); index1++) {
							for (int index2 = 0; index2 < (int) (3); index2++) {
								if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getBoolean("stopMining")) == (false))) {
									if ((((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
											.getMaterial() == net.minecraft.block.material.Material.ROCK) == (true))
											|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
													.getMaterial() == net.minecraft.block.material.Material.IRON) == (true))
													|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
															.getMaterial() == net.minecraft.block.material.Material.ANVIL) == (true))
															|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																	.getMaterial() == net.minecraft.block.material.Material.ICE) == (true))
																	|| ((((world
																			.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																					.getMaterial() == net.minecraft.block.material.Material.PACKED_ICE) == (true))
																			|| ((((world.getBlockState(
																					new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																							.getMaterial() == net.minecraft.block.material.Material.SHULKER) == (true))
																					|| (((world.getBlockState(
																							new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																									.getMaterial() == net.minecraft.block.material.Material.PISTON) == (true))))))))
											&& (!((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
													.getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())))) {
										if (world instanceof World) {
											Block.spawnDrops(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))),
													(World) world, new BlockPos((int) (posX), (int) (posY), (int) (posZ)));
											world.destroyBlock(new BlockPos((int) (posX), (int) (posY), (int) (posZ)), false);
										}
										if (((new Object() {
											public boolean checkGamemode(Entity _ent) {
												if (_ent instanceof ServerPlayerEntity) {
													return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
												} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
													NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
															.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
													return _npi != null && _npi.getGameType() == GameType.CREATIVE;
												}
												return false;
											}
										}.checkGamemode(entity)) == (false))) {
											{
												ItemStack _ist = ((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY);
												if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
													_ist.shrink(1);
													_ist.setDamage(0);
												}
											}
											if ((((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getDamage()) == 0)) {
												if (world instanceof World && !world.isRemote()) {
													((World) world).playSound(null,
															new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()),
																	(int) (entity.getPosZ())),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("negative_n:n-music_8bit")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9);
												} else {
													((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("negative_n:n-music_8bit")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9, false);
												}
												if (entity instanceof PlayerEntity) {
													ItemStack _stktoremove = ((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY);
													((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
															(int) 1, ((PlayerEntity) entity).container.func_234641_j_());
												}
												((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
														.getOrCreateTag().putBoolean("stopMining", (true));
											}
										}
									}
								}
								posZ = (double) ((posZ) + 1);
							}
							posZ = (double) (z - 1);
							posX = (double) ((posX) + 1);
						}
						posX = (double) (x - 1);
						posZ = (double) (z - 1);
						posY = (double) ((posY) + 1);
					}
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() instanceof ShovelItem)) {
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
						&& ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.CLAY) == (true))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.EARTH) == (true))
										|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
												.getMaterial() == net.minecraft.block.material.Material.ORGANIC) == (true))
												|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
														.getMaterial() == net.minecraft.block.material.Material.SAND) == (true))
														|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
																.getMaterial() == net.minecraft.block.material.Material.SNOW) == (true)))))))) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					posX = (double) (x - 1);
					posY = (double) (y - 1);
					posZ = (double) (z - 1);
					for (int index3 = 0; index3 < (int) (3); index3++) {
						for (int index4 = 0; index4 < (int) (3); index4++) {
							for (int index5 = 0; index5 < (int) (3); index5++) {
								if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getBoolean("stopMining")) == (false))) {
									if (((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
											.getMaterial() == net.minecraft.block.material.Material.CLAY) == (true))
											|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
													.getMaterial() == net.minecraft.block.material.Material.EARTH) == (true))
													|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
															.getMaterial() == net.minecraft.block.material.Material.ORGANIC) == (true))
															|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																	.getMaterial() == net.minecraft.block.material.Material.SAND) == (true))
																	|| (((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																			.getMaterial() == net.minecraft.block.material.Material.SNOW) == (true))))))) {
										if (world instanceof World) {
											Block.spawnDrops(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))),
													(World) world, new BlockPos((int) (posX), (int) (posY), (int) (posZ)));
											world.destroyBlock(new BlockPos((int) (posX), (int) (posY), (int) (posZ)), false);
										}
										if (((new Object() {
											public boolean checkGamemode(Entity _ent) {
												if (_ent instanceof ServerPlayerEntity) {
													return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
												} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
													NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
															.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
													return _npi != null && _npi.getGameType() == GameType.CREATIVE;
												}
												return false;
											}
										}.checkGamemode(entity)) == (false))) {
											{
												ItemStack _ist = ((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY);
												if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
													_ist.shrink(1);
													_ist.setDamage(0);
												}
											}
											if ((((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getDamage()) == 0)) {
												if (world instanceof World && !world.isRemote()) {
													((World) world).playSound(null,
															new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()),
																	(int) (entity.getPosZ())),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("entity.item.break")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9);
												} else {
													((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("entity.item.break")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9, false);
												}
												if (entity instanceof PlayerEntity) {
													ItemStack _stktoremove = ((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY);
													((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
															(int) 1, ((PlayerEntity) entity).container.func_234641_j_());
												}
												((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
														.getOrCreateTag().putBoolean("stopMining", (true));
											}
										}
									}
								}
								posZ = (double) ((posZ) + 1);
							}
							posZ = (double) (z - 1);
							posX = (double) ((posX) + 1);
						}
						posX = (double) (x - 1);
						posZ = (double) (z - 1);
						posY = (double) ((posY) + 1);
					}
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() instanceof AxeItem)) {
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
						&& ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.WOOD) == (true))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.GOURD) == (true))
										|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
												.getMaterial() == net.minecraft.block.material.Material.BAMBOO_SAPLING) == (true))
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
														.getMaterial() == net.minecraft.block.material.Material.BAMBOO) == (true))))))) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					posX = (double) (x - 1);
					posY = (double) (y - 1);
					posZ = (double) (z - 1);
					for (int index6 = 0; index6 < (int) (3); index6++) {
						for (int index7 = 0; index7 < (int) (3); index7++) {
							for (int index8 = 0; index8 < (int) (3); index8++) {
								if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getBoolean("stopMining")) == (false))) {
									if (((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
											.getMaterial() == net.minecraft.block.material.Material.WOOD) == (true))
											|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
													.getMaterial() == net.minecraft.block.material.Material.GOURD) == (true))
													|| ((((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
															.getMaterial() == net.minecraft.block.material.Material.BAMBOO_SAPLING) == (true))
															|| (((world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))))
																	.getMaterial() == net.minecraft.block.material.Material.BAMBOO) == (true)))))) {
										if (world instanceof World) {
											Block.spawnDrops(world.getBlockState(new BlockPos((int) (posX), (int) (posY), (int) (posZ))),
													(World) world, new BlockPos((int) (posX), (int) (posY), (int) (posZ)));
											world.destroyBlock(new BlockPos((int) (posX), (int) (posY), (int) (posZ)), false);
										}
										if (((new Object() {
											public boolean checkGamemode(Entity _ent) {
												if (_ent instanceof ServerPlayerEntity) {
													return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
												} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
													NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
															.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
													return _npi != null && _npi.getGameType() == GameType.CREATIVE;
												}
												return false;
											}
										}.checkGamemode(entity)) == (false))) {
											{
												ItemStack _ist = ((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY);
												if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
													_ist.shrink(1);
													_ist.setDamage(0);
												}
											}
											if ((((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getDamage()) == 0)) {
												if (world instanceof World && !world.isRemote()) {
													((World) world).playSound(null,
															new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()),
																	(int) (entity.getPosZ())),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("entity.item.break")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9);
												} else {
													((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("entity.item.break")),
															SoundCategory.NEUTRAL, (float) 1, (float) 0.9, false);
												}
												if (entity instanceof PlayerEntity) {
													ItemStack _stktoremove = ((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY);
													((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
															(int) 1, ((PlayerEntity) entity).container.func_234641_j_());
												}
												((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
														.getOrCreateTag().putBoolean("stopMining", (true));
											}
										}
									}
								}
								posZ = (double) ((posZ) + 1);
							}
							posZ = (double) (z - 1);
							posX = (double) ((posX) + 1);
						}
						posX = (double) (x - 1);
						posZ = (double) (z - 1);
						posY = (double) ((posY) + 1);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
