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

import net.killarexe.negativen.entity.WitherNEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WitherNRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(WitherNEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelwither_n(), 4f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/wither_n.png");
					}
				};
			});
			RenderingRegistry.registerEntityRenderingHandler(WitherNEntity.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelwither_n extends EntityModel<Entity> {
		private final ModelRenderer upperBodyPart1;
		private final ModelRenderer upperBodyPart2;
		private final ModelRenderer upperBodyPart3;
		private final ModelRenderer head1;
		private final ModelRenderer head2;
		private final ModelRenderer head3;
		public Modelwither_n() {
			textureWidth = 64;
			textureHeight = 64;
			upperBodyPart1 = new ModelRenderer(this);
			upperBodyPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyPart1.setTextureOffset(0, 16).addBox(-10.0F, 3.9F, -0.5F, 20.0F, 3.0F, 3.0F, 0.0F, true);
			upperBodyPart2 = new ModelRenderer(this);
			upperBodyPart2.setRotationPoint(2.0F, 6.9F, -0.5F);
			upperBodyPart2.setTextureOffset(0, 22).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, 0.0F, true);
			upperBodyPart2.setTextureOffset(24, 22).addBox(-7.0F, 1.5F, 0.5F, 11.0F, 2.0F, 2.0F, 0.0F, true);
			upperBodyPart2.setTextureOffset(24, 22).addBox(-7.0F, 4.0F, 0.5F, 11.0F, 2.0F, 2.0F, 0.0F, true);
			upperBodyPart2.setTextureOffset(24, 22).addBox(-7.0F, 6.5F, 0.5F, 11.0F, 2.0F, 2.0F, 0.0F, true);
			upperBodyPart3 = new ModelRenderer(this);
			upperBodyPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyPart3.setTextureOffset(12, 22).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);
			head1 = new ModelRenderer(this);
			head1.setRotationPoint(0.0F, 4.0F, 0.0F);
			head1.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);
			head2 = new ModelRenderer(this);
			head2.setRotationPoint(9.0F, 6.0F, -1.0F);
			head2.setTextureOffset(32, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
			head3 = new ModelRenderer(this);
			head3.setRotationPoint(-9.0F, 6.0F, -1.0F);
			head3.setTextureOffset(32, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			upperBodyPart1.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyPart2.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyPart3.render(matrixStack, buffer, packedLight, packedOverlay);
			head1.render(matrixStack, buffer, packedLight, packedOverlay);
			head2.render(matrixStack, buffer, packedLight, packedOverlay);
			head3.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.upperBodyPart3.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.upperBodyPart2.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.upperBodyPart1.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.head1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.head3.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head3.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
