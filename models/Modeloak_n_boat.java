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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}