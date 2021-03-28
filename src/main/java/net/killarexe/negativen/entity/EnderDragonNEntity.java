
package net.killarexe.negativen.entity;

import net.minecraft.block.material.Material;

@NegativeNModElements.ModElement.Tag
public class EnderDragonNEntity extends NegativeNModElements.ModElement {

	public static EntityType entity = null;

	@ObjectHolder("negative_n:entitybulletender_dragon_n")
	public static final EntityType arrow = null;

	public EnderDragonNEntity(NegativeNModElements instance) {
		super(instance, 661);

		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());

	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 2.8000000000000003f))
						.build("ender_dragon_n").setRegistryName("ender_dragon_n");

		elements.entities.add(() -> entity);

		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletender_dragon_n").setRegistryName("entitybulletender_dragon_n"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);

	}

	private static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelenderdragon_n(), 1.2000000000000002f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/dragon-n.png");
					}
				};
			});

			RenderingRegistry.registerEntityRenderingHandler(arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}
	}

	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 100);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);

		ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);

		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

			enablePersistence();

			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));

			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {

			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, this, this.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - this.getPosX();
			double d3 = target.getPosZ() - this.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			world.addEntity(entityarrow);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);

		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();

			this.setNoGravity(true);

		}

	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	private static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {

		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}
	}

	// Made with Blockbench 3.6.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modelenderdragon_n extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer jaw;
		private final ModelRenderer neck;
		private final ModelRenderer body;
		private final ModelRenderer wing;
		private final ModelRenderer wingtip;
		private final ModelRenderer wing1;
		private final ModelRenderer wingtip1;
		private final ModelRenderer rearleg;
		private final ModelRenderer rearleg1;
		private final ModelRenderer frontleg;
		private final ModelRenderer frontleg1;
		private final ModelRenderer rearlegtip;
		private final ModelRenderer rearlegtip1;
		private final ModelRenderer frontlegtip;
		private final ModelRenderer frontlegtip1;
		private final ModelRenderer rearfoot;
		private final ModelRenderer rearfoot1;
		private final ModelRenderer frontfoot;
		private final ModelRenderer frontfoot1;

		public Modelenderdragon_n() {
			textureWidth = 256;
			textureHeight = 256;

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(176, 44).addBox(-6.0F, -1.0F, -24.0F, 12.0F, 5.0F, 16.0F, 0.0F, true);
			head.setTextureOffset(112, 30).addBox(-8.0F, -8.0F, -10.0F, 16.0F, 16.0F, 16.0F, 0.0F, true);
			head.setTextureOffset(0, 0).addBox(3.0F, -12.0F, -4.0F, 2.0F, 4.0F, 6.0F, 0.0F, true);
			head.setTextureOffset(112, 0).addBox(3.0F, -3.0F, -22.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);
			head.setTextureOffset(0, 0).addBox(-5.0F, -12.0F, -4.0F, 2.0F, 4.0F, 6.0F, 0.0F, true);
			head.setTextureOffset(112, 0).addBox(-5.0F, -3.0F, -22.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

			jaw = new ModelRenderer(this);
			jaw.setRotationPoint(0.0F, 4.0F, -8.0F);
			jaw.setTextureOffset(176, 65).addBox(-6.0F, 0.0F, -16.0F, 12.0F, 4.0F, 16.0F, 0.0F, true);

			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, 0.0F, 0.0F);
			neck.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, true);
			neck.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, true);

			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 4.0F, 8.0F);
			body.setTextureOffset(0, 0).addBox(-12.0F, 0.0F, -16.0F, 24.0F, 24.0F, 64.0F, 0.0F, true);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, -10.0F, 2.0F, 6.0F, 12.0F, 0.0F, true);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, 10.0F, 2.0F, 6.0F, 12.0F, 0.0F, true);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, 30.0F, 2.0F, 6.0F, 12.0F, 0.0F, true);

			wing = new ModelRenderer(this);
			wing.setRotationPoint(12.0F, 5.0F, 2.0F);
			wing.setTextureOffset(112, 88).addBox(0.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, 0.0F, true);
			wing.setTextureOffset(-56, 88).addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.0F, true);

			wingtip = new ModelRenderer(this);
			wingtip.setRotationPoint(56.0F, 0.0F, 0.0F);
			wingtip.setTextureOffset(112, 136).addBox(0.0F, -2.0F, -2.0F, 56.0F, 4.0F, 4.0F, 0.0F, true);
			wingtip.setTextureOffset(-56, 144).addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.0F, true);

			wing1 = new ModelRenderer(this);
			wing1.setRotationPoint(-12.0F, 5.0F, 2.0F);
			wing1.setTextureOffset(112, 88).addBox(0.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, 0.0F, true);
			wing1.setTextureOffset(-56, 88).addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.0F, true);

			wingtip1 = new ModelRenderer(this);
			wingtip1.setRotationPoint(56.0F, 0.0F, 0.0F);
			wingtip1.setTextureOffset(112, 136).addBox(0.0F, -2.0F, -2.0F, 56.0F, 4.0F, 4.0F, 0.0F, true);
			wingtip1.setTextureOffset(-56, 144).addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.0F, true);

			rearleg = new ModelRenderer(this);
			rearleg.setRotationPoint(16.0F, 16.0F, 42.0F);
			rearleg.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 32.0F, 16.0F, 0.0F, true);

			rearleg1 = new ModelRenderer(this);
			rearleg1.setRotationPoint(-16.0F, 16.0F, 42.0F);
			rearleg1.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 32.0F, 16.0F, 0.0F, true);

			frontleg = new ModelRenderer(this);
			frontleg.setRotationPoint(12.0F, 20.0F, 2.0F);
			frontleg.setTextureOffset(112, 104).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, true);

			frontleg1 = new ModelRenderer(this);
			frontleg1.setRotationPoint(-12.0F, 20.0F, 2.0F);
			frontleg1.setTextureOffset(112, 104).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, true);

			rearlegtip = new ModelRenderer(this);
			rearlegtip.setRotationPoint(0.0F, 32.0F, -4.0F);
			rearlegtip.setTextureOffset(196, 0).addBox(-6.0F, -2.0F, 0.0F, 12.0F, 32.0F, 12.0F, 0.0F, true);

			rearlegtip1 = new ModelRenderer(this);
			rearlegtip1.setRotationPoint(0.0F, 32.0F, -4.0F);
			rearlegtip1.setTextureOffset(196, 0).addBox(-6.0F, -2.0F, 0.0F, 12.0F, 32.0F, 12.0F, 0.0F, true);

			frontlegtip = new ModelRenderer(this);
			frontlegtip.setRotationPoint(0.0F, 20.0F, -1.0F);
			frontlegtip.setTextureOffset(226, 138).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, true);

			frontlegtip1 = new ModelRenderer(this);
			frontlegtip1.setRotationPoint(0.0F, 20.0F, -1.0F);
			frontlegtip1.setTextureOffset(226, 138).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, true);

			rearfoot = new ModelRenderer(this);
			rearfoot.setRotationPoint(0.0F, 31.0F, 4.0F);
			rearfoot.setTextureOffset(112, 0).addBox(-9.0F, 0.0F, -20.0F, 18.0F, 6.0F, 24.0F, 0.0F, true);

			rearfoot1 = new ModelRenderer(this);
			rearfoot1.setRotationPoint(0.0F, 31.0F, 4.0F);
			rearfoot1.setTextureOffset(112, 0).addBox(-9.0F, 0.0F, -20.0F, 18.0F, 6.0F, 24.0F, 0.0F, true);

			frontfoot = new ModelRenderer(this);
			frontfoot.setRotationPoint(0.0F, 23.0F, 0.0F);
			frontfoot.setTextureOffset(144, 104).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 4.0F, 16.0F, 0.0F, true);

			frontfoot1 = new ModelRenderer(this);
			frontfoot1.setRotationPoint(0.0F, 23.0F, 0.0F);
			frontfoot1.setTextureOffset(144, 104).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 4.0F, 16.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			jaw.render(matrixStack, buffer, packedLight, packedOverlay);
			neck.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			wing.render(matrixStack, buffer, packedLight, packedOverlay);
			wingtip.render(matrixStack, buffer, packedLight, packedOverlay);
			wing1.render(matrixStack, buffer, packedLight, packedOverlay);
			wingtip1.render(matrixStack, buffer, packedLight, packedOverlay);
			rearleg.render(matrixStack, buffer, packedLight, packedOverlay);
			rearleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			frontleg.render(matrixStack, buffer, packedLight, packedOverlay);
			frontleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			rearlegtip.render(matrixStack, buffer, packedLight, packedOverlay);
			rearlegtip1.render(matrixStack, buffer, packedLight, packedOverlay);
			frontlegtip.render(matrixStack, buffer, packedLight, packedOverlay);
			frontlegtip1.render(matrixStack, buffer, packedLight, packedOverlay);
			rearfoot.render(matrixStack, buffer, packedLight, packedOverlay);
			rearfoot1.render(matrixStack, buffer, packedLight, packedOverlay);
			frontfoot.render(matrixStack, buffer, packedLight, packedOverlay);
			frontfoot1.render(matrixStack, buffer, packedLight, packedOverlay);
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
