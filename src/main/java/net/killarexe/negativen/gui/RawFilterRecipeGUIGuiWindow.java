
package net.killarexe.negativen.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.killarexe.negativen.procedures.PreviousPageButtonConditionProcedure;
import net.killarexe.negativen.procedures.NextPageButtonConditionProcedure;
import net.killarexe.negativen.NegativeNMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class RawFilterRecipeGUIGuiWindow extends ContainerScreen<RawFilterRecipeGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public RawFilterRecipeGUIGuiWindow(RawFilterRecipeGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("negative_n:textures/raw_filter_recipe_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("negative_n:textures/powder_n_icon.png"));
		this.blit(ms, this.guiLeft + 16, this.guiTop + 35, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("negative_n:textures/plus.png"));
		this.blit(ms, this.guiLeft + 35, this.guiTop + 36, 0, 0, 13, 13, 13, 13);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Raw Filter", 6, 7, -12829636);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("chanceIron")) + "", 150, 34, -12829636);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("chanceCopper")) + "", 150, 7, -12829636);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("chanceGold")) + "", 150, 61, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 177, this.guiTop + 142, 45, 20, new StringTextComponent("Next"), e -> {
			if (NextPageButtonConditionProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new RawFilterRecipeGUIGui.ButtonPressedMessage(0, x, y, z));
				RawFilterRecipeGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (NextPageButtonConditionProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -65, this.guiTop + 142, 65, 20, new StringTextComponent("Previous"), e -> {
			if (PreviousPageButtonConditionProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new RawFilterRecipeGUIGui.ButtonPressedMessage(1, x, y, z));
				RawFilterRecipeGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (PreviousPageButtonConditionProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
