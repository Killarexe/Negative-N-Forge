
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
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.killarexe.negativen.itemgroup.NegativeNMobsItemGroup;
import net.killarexe.negativen.NegativeNModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NegativeNModElements.ModElement.Tag
public class SquidNEntity extends NegativeNModElements.ModElement {
	public static EntityType entity = null;
	public SquidNEntity(NegativeNModElements instance) {
		super(instance, 95);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.immuneToFire().size(0.6f, 1.8f)).build("squid_n").setRegistryName("squid_n");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13108, -26215, new Item.Properties().group(NegativeNMobsItemGroup.tab))
				.setRegistryName("squid_n_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("negative_n:negative").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:desert_n").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:oak_nforest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:birch_n_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:plains_n").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:dark_oak_n_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:jungle_n").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:spruce_forest_n").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:montains_n").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("negative_n:acacia_n_biome").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(entity, 20, 4, 4));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SquidEntity::func_223365_b);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsquid_n(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/squid_n.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		ammma = ammma.createMutableAttribute(ForgeMod.SWIM_SPEED.get(), 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttributeValue(Attributes.MOVEMENT_SPEED))));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.WATER;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.squirt")), 0.15f,
					1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.death"));
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelsquid_n extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer tentacle1;
		private final ModelRenderer tentacle2;
		private final ModelRenderer tentacle3;
		private final ModelRenderer tentacle4;
		private final ModelRenderer tentacle5;
		private final ModelRenderer tentacle6;
		private final ModelRenderer tentacle7;
		private final ModelRenderer tentacle8;
		public Modelsquid_n() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 16.0F, 12.0F, 0.0F, true);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(-5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle1, 0.0F, -1.5708F, 0.0F);
			tentacle1.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle2, 0.0F, -0.7854F, 0.0F);
			tentacle2.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(0.0F, 31.0F, 5.0F);
			tentacle3.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle4, 0.0F, 0.7854F, 0.0F);
			tentacle4.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle5, 0.0F, 1.5708F, 0.0F);
			tentacle5.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle6 = new ModelRenderer(this);
			tentacle6.setRotationPoint(3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle6, 0.0F, 2.3562F, 0.0F);
			tentacle6.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle7 = new ModelRenderer(this);
			tentacle7.setRotationPoint(0.0F, 31.0F, -5.0F);
			setRotationAngle(tentacle7, 0.0F, 3.1416F, 0.0F);
			tentacle7.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
			tentacle8 = new ModelRenderer(this);
			tentacle8.setRotationPoint(-3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle8, 0.0F, 3.927F, 0.0F);
			tentacle8.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle7.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle8.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
