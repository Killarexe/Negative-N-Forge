
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

import net.killarexe.negativen.NegativeNMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DimensionStickGUIGuiWindow extends ContainerScreen<DimensionStickGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public DimensionStickGUIGuiWindow(DimensionStickGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 250;
		this.ySize = 200;
	}
	private static final ResourceLocation texture = new ResourceLocation("negative_n:textures/dimensionstickgui.png");
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
		this.font.drawString(ms, "Choose your Dimension", 70, 1, -16777216);
		this.font.drawString(ms, "DimStick Ver 1.2", 160, 182, -16777216);
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
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 19, 90, 20, new StringTextComponent("Owerworld"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(0, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 46, 60, 20, new StringTextComponent("Nether"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(1, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 73, 30, 20, new StringTextComponent("End"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(2, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 100, 100, 20, new StringTextComponent("Underworld"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(3, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 127, 80, 20, new StringTextComponent("Nether-N"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(4, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 154, 50, 20, new StringTextComponent("Start"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(5, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 46, 40, 20, new StringTextComponent("None"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(6, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 19, 100, 20, new StringTextComponent("MineingDim"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(7, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 73, 100, 20, new StringTextComponent("ClassicDim"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(8, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 100, 110, 20, new StringTextComponent("ClassicNDim"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(9, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 116, this.guiTop + 127, 95, 20, new StringTextComponent("Classic Nether"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(10, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 155, 105, 20, new StringTextComponent("Classic Nether-N"), e -> {
			if (true) {
				NegativeNMod.PACKET_HANDLER.sendToServer(new DimensionStickGUIGui.ButtonPressedMessage(11, x, y, z));
				DimensionStickGUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
	}
}
