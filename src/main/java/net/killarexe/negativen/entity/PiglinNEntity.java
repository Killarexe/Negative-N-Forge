
package net.killarexe.negativen.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.killarexe.negativen.procedures.PiglinNConditionProcedure;
import net.killarexe.negativen.itemgroup.NegativeNMobsItemGroup;
import net.killarexe.negativen.item.GoldNArmorItem;
import net.killarexe.negativen.NegativeNModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@NegativeNModElements.ModElement.Tag
public class PiglinNEntity extends NegativeNModElements.ModElement {
	public static EntityType entity = null;
	public PiglinNEntity(NegativeNModElements instance) {
		super(instance, 91);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("piglin_n")
						.setRegistryName("piglin_n");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16737844, -13382401, new Item.Properties().group(NegativeNMobsItemGroup.tab))
				.setRegistryName("piglin_n_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("negative_n:nethern").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:nether_n_warped_biome").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:nether_n_crimson_biome").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 20, 4, 4));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		DungeonHooks.addDungeonMob(entity, 180);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpiglin_n(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/piglin_n.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 20);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(GoldNArmorItem.boots, (int) (1)));
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && PiglinNConditionProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.step")), 0.15f,
					1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.piglin.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelpiglin_n extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer headwear;
		private final ModelRenderer body;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_ear;
		private final ModelRenderer right_ear;
		public Modelpiglin_n() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(31, 1).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(2, 4).addBox(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(2, 0).addBox(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			headwear = new ModelRenderer(this);
			headwear.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			left_arm.setTextureOffset(32, 48).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_arm.setTextureOffset(48, 48).addBox(9.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
			right_arm.setTextureOffset(40, 16).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_arm.setTextureOffset(40, 32).addBox(-13.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			left_leg.setTextureOffset(16, 48).addBox(2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_leg.setTextureOffset(0, 48).addBox(2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
			right_leg.setTextureOffset(0, 16).addBox(-6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_leg.setTextureOffset(0, 32).addBox(-6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			left_ear = new ModelRenderer(this);
			left_ear.setRotationPoint(-5.25F, -6.0F, 0.0F);
			left_ear.setTextureOffset(51, 6).addBox(10.25F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
			right_ear = new ModelRenderer(this);
			right_ear.setRotationPoint(5.5F, -6.0F, 0.0F);
			right_ear.setTextureOffset(39, 6).addBox(-11.5F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			headwear.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_ear.render(matrixStack, buffer, packedLight, packedOverlay);
			right_ear.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.headwear.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.headwear.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_ear.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.right_ear.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_ear.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.left_ear.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
