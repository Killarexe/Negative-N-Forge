package net.killarexe.negativen.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import net.killarexe.negativen.entity.EnderDragonNEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EnderDragonNRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(EnderDragonNEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelenderdragon_n(), 1.2000000000000002f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/dragon-n.png");
					}
				};
			});
			RenderingRegistry.registerEntityRenderingHandler(EnderDragonNEntity.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
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
