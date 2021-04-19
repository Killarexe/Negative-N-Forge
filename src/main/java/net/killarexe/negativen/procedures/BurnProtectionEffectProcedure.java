package net.killarexe.negativen.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.killarexe.negativen.item.NetheriteNArmorItem;
import net.killarexe.negativen.item.ArnurendiamantinverseItem;
import net.killarexe.negativen.enchantment.ResistantEnchantment;
import net.killarexe.negativen.enchantment.EyewearEnchantment;
import net.killarexe.negativen.enchantment.BurnProtectionEnchantment;
import net.killarexe.negativen.enchantment.AntiPotionEnchantment;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collection;

@NegativeNModElements.ModElement.Tag
public class BurnProtectionEffectProcedure extends NegativeNModElements.ModElement {
	public BurnProtectionEffectProcedure(NegativeNModElements instance) {
		super(instance, 698);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NegativeNMod.LOGGER.warn("Failed to load dependency entity for procedure BurnProtectionEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double playerHealth = 0;
		playerHealth = (double) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
		if (((EnchantmentHelper.getEnchantmentLevel(BurnProtectionEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY))) > 0)) {
			if ((entity.isBurning())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 40, (int) 1, (false), (false)));
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(EyewearEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY))) > 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 40, (int) 1, (false), (false)));
		} else if (((EnchantmentHelper.getEnchantmentLevel(AntiPotionEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY))) > 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
		} else if (((EnchantmentHelper.getEnchantmentLevel(ResistantEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY))) > 0)) {
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.HEALTH_BOOST)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (((new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.HEALTH_BOOST)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity)) == 40)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 6000,
								(int) (EnchantmentHelper.getEnchantmentLevel(ResistantEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
												: ItemStack.EMPTY))),
								(false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) (playerHealth));
				}
			} else if ((!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.HEALTH_BOOST)
								return true;
						}
					}
					return false;
				}
			}.check(entity)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 6000,
							(int) (EnchantmentHelper.getEnchantmentLevel(ResistantEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
											: ItemStack.EMPTY))),
							(false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 20, (int) 255));
			}
		}
		if (((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == new ItemStack(ArnurendiamantinverseItem.helmet, (int) (1)).getItem())
				&& ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == new ItemStack(ArnurendiamantinverseItem.body, (int) (1)).getItem())
						&& ((((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
								: ItemStack.EMPTY).getItem() == new ItemStack(ArnurendiamantinverseItem.legs, (int) (1)).getItem())
								&& (((entity instanceof LivingEntity)
										? ((LivingEntity) entity)
												.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
										: ItemStack.EMPTY).getItem() == new ItemStack(ArnurendiamantinverseItem.boots, (int) (1)).getItem()))))) {
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("negative_n:couvremoidenegatf")))
							.isDone()
					: false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("negative_n:couvremoidenegatf"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
		if (((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == new ItemStack(NetheriteNArmorItem.helmet, (int) (1)).getItem())
				&& ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == new ItemStack(NetheriteNArmorItem.body, (int) (1)).getItem())
						&& ((((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
								: ItemStack.EMPTY).getItem() == new ItemStack(NetheriteNArmorItem.legs, (int) (1)).getItem())
								&& (((entity instanceof LivingEntity)
										? ((LivingEntity) entity)
												.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
										: ItemStack.EMPTY).getItem() == new ItemStack(NetheriteNArmorItem.boots, (int) (1)).getItem()))))) {
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("negative_n:cover_me_with_debris_n")))
							.isDone()
					: false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("negative_n:cover_me_with_debris_n"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
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
}
