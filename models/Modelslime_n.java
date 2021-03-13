// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelslime_n extends EntityModel<Entity> {
	private final ModelRenderer cube;
	private final ModelRenderer eye0;
	private final ModelRenderer eye1;
	private final ModelRenderer mouth;
	private final ModelRenderer cube;
	private final ModelRenderer eye0;
	private final ModelRenderer eye1;
	private final ModelRenderer mouth;

	public Modelslime_n() {
		textureWidth = 64;
		textureHeight = 32;

		cube = new ModelRenderer(this);
		cube.setRotationPoint(0.0F, 0.0F, 0.0F);
		cube.setTextureOffset(0, 0).addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		eye0 = new ModelRenderer(this);
		eye0.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye0.setTextureOffset(32, 0).addBox(1.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		eye1 = new ModelRenderer(this);
		eye1.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye1.setTextureOffset(32, 4).addBox(-3.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		mouth.setTextureOffset(32, 8).addBox(-1.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		cube = new ModelRenderer(this);
		cube.setRotationPoint(0.0F, 0.0F, 0.0F);
		cube.setTextureOffset(0, 16).addBox(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);

		eye0 = new ModelRenderer(this);
		eye0.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye0.setTextureOffset(32, 0).addBox(1.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		eye1 = new ModelRenderer(this);
		eye1.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye1.setTextureOffset(32, 4).addBox(-3.3F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		mouth.setTextureOffset(32, 8).addBox(-1.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		cube.render(matrixStack, buffer, packedLight, packedOverlay);
		eye0.render(matrixStack, buffer, packedLight, packedOverlay);
		eye1.render(matrixStack, buffer, packedLight, packedOverlay);
		mouth.render(matrixStack, buffer, packedLight, packedOverlay);
		cube.render(matrixStack, buffer, packedLight, packedOverlay);
		eye0.render(matrixStack, buffer, packedLight, packedOverlay);
		eye1.render(matrixStack, buffer, packedLight, packedOverlay);
		mouth.render(matrixStack, buffer, packedLight, packedOverlay);
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