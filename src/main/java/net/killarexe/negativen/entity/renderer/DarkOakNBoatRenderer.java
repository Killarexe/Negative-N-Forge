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
import net.minecraft.client.renderer.entity.MobRenderer;

import net.killarexe.negativen.entity.DarkOakNBoatEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkOakNBoatRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkOakNBoatEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeloak_n_boat(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("negative_n:textures/dark_oak_n_boat.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeloak_n_boat extends EntityModel<Entity> {
		private final ModelRenderer bottom;
		private final ModelRenderer front;
		private final ModelRenderer back;
		private final ModelRenderer right;
		private final ModelRenderer left;
		public Modeloak_n_boat() {
			textureWidth = 128;
			textureHeight = 64;
			bottom = new ModelRenderer(this);
			bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bottom, 1.5708F, 1.5708F, 0.0F);
			bottom.setTextureOffset(0, 0).addBox(-14.0F, -8.0F, 0.0F, 28.0F, 16.0F, 3.0F, 0.0F, true);
			front = new ModelRenderer(this);
			front.setRotationPoint(7.0F, 24.0F, 0.0F);
			front.setTextureOffset(0, 27).addBox(-15.0F, -9.0F, -16.0F, 16.0F, 6.0F, 2.0F, 0.0F, true);
			back = new ModelRenderer(this);
			back.setRotationPoint(8.0F, 21.0F, 13.0F);
			back.setTextureOffset(0, 19).addBox(-16.0F, -6.0F, 0.0F, 16.0F, 6.0F, 2.0F, 0.0F, true);
			right = new ModelRenderer(this);
			right.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(right, 0.0F, -1.5708F, 0.0F);
			right.setTextureOffset(0, 35).addBox(-14.0F, -9.0F, -10.0F, 28.0F, 6.0F, 2.0F, 0.0F, true);
			left = new ModelRenderer(this);
			left.setRotationPoint(0.0F, 42.0F, 0.0F);
			setRotationAngle(left, 0.0F, -1.5708F, 0.0F);
			left.setTextureOffset(0, 43).addBox(-14.0F, -27.0F, 8.0F, 28.0F, 6.0F, 2.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bottom.render(matrixStack, buffer, packedLight, packedOverlay);
			front.render(matrixStack, buffer, packedLight, packedOverlay);
			back.render(matrixStack, buffer, packedLight, packedOverlay);
			right.render(matrixStack, buffer, packedLight, packedOverlay);
			left.render(matrixStack, buffer, packedLight, packedOverlay);
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
