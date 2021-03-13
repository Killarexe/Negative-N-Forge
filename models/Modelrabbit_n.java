// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelrabbit_n extends EntityModel<Entity> {
	private final ModelRenderer rearFootLeft;
	private final ModelRenderer rearFootRight;
	private final ModelRenderer haunchLeft;
	private final ModelRenderer haunchRight;
	private final ModelRenderer body;
	private final ModelRenderer frontLegLeft;
	private final ModelRenderer frontLegRight;
	private final ModelRenderer head;
	private final ModelRenderer earRight;
	private final ModelRenderer earLeft;
	private final ModelRenderer tail;
	private final ModelRenderer nose;

	public Modelrabbit_n() {
		textureWidth = 64;
		textureHeight = 32;

		rearFootLeft = new ModelRenderer(this);
		rearFootLeft.setRotationPoint(-3.0F, 17.5F, 3.7F);
		rearFootLeft.setTextureOffset(8, 24).addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F, 0.0F, false);

		rearFootRight = new ModelRenderer(this);
		rearFootRight.setRotationPoint(3.0F, 17.5F, 3.7F);
		rearFootRight.setTextureOffset(26, 24).addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F, 0.0F, false);

		haunchLeft = new ModelRenderer(this);
		haunchLeft.setRotationPoint(-3.0F, 17.5F, 3.7F);
		setRotationAngle(haunchLeft, -0.3491F, 0.0F, 0.0F);
		haunchLeft.setTextureOffset(16, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);

		haunchRight = new ModelRenderer(this);
		haunchRight.setRotationPoint(3.0F, 17.5F, 3.7F);
		setRotationAngle(haunchRight, -0.3491F, 0.0F, 0.0F);
		haunchRight.setTextureOffset(30, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 19.0F, 8.0F);
		setRotationAngle(body, -0.3491F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -10.0F, 6.0F, 5.0F, 10.0F, 0.0F, false);

		frontLegLeft = new ModelRenderer(this);
		frontLegLeft.setRotationPoint(-3.0F, 17.0F, -1.0F);
		setRotationAngle(frontLegLeft, -0.1745F, 0.0F, 0.0F);
		frontLegLeft.setTextureOffset(8, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		frontLegRight = new ModelRenderer(this);
		frontLegRight.setRotationPoint(3.0F, 17.0F, -1.0F);
		setRotationAngle(frontLegRight, -0.1745F, 0.0F, 0.0F);
		frontLegRight.setTextureOffset(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 16.0F, -1.0F);
		head.setTextureOffset(32, 0).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		earRight = new ModelRenderer(this);
		earRight.setRotationPoint(0.0F, 16.0F, -1.0F);
		setRotationAngle(earRight, 0.0F, 0.2618F, 0.0F);
		earRight.setTextureOffset(52, 0).addBox(0.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		earLeft = new ModelRenderer(this);
		earLeft.setRotationPoint(0.0F, 16.0F, -1.0F);
		setRotationAngle(earLeft, 0.0F, -0.2618F, 0.0F);
		earLeft.setTextureOffset(58, 0).addBox(-2.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 20.0F, 7.0F);
		setRotationAngle(tail, -0.3491F, 0.0F, 0.0F);
		tail.setTextureOffset(52, 6).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 16.0F, -1.0F);
		nose.setTextureOffset(32, 9).addBox(-0.5F, -2.5F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		rearFootLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		rearFootRight.render(matrixStack, buffer, packedLight, packedOverlay);
		haunchLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		haunchRight.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLegLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLegRight.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		earRight.render(matrixStack, buffer, packedLight, packedOverlay);
		earLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		nose.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.nose.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.nose.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}