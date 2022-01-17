
package net.mcreator.sobr.gui;

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

import net.mcreator.sobr.SobrMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ScrollGUIGuiWindow extends ContainerScreen<ScrollGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ScrollGUIGui.guistate;
	public ScrollGUIGuiWindow(ScrollGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("sobr:textures/scroll_gui.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/spell_night_vision_16.png"));
		this.blit(ms, this.guiLeft + 25, this.guiTop + 71, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/spell_knockback_16.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 71, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/soul_end.png"));
		this.blit(ms, this.guiLeft + 152, this.guiTop + 9, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/soul_nether.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 27, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/soul_other.png"));
		this.blit(ms, this.guiLeft + 151, this.guiTop + 27, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/soul_surface.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 9, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/blank_scroll.png"));
		this.blit(ms, this.guiLeft + 79, this.guiTop + 31, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/scroll_table_1.png"));
		this.blit(ms, this.guiLeft + 44, this.guiTop + 0, 0, 0, 32, 32, 32, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/scroll_table_2.png"));
		this.blit(ms, this.guiLeft + 107, this.guiTop + 0, 0, 0, 32, 32, 32, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/knowledge_book.png"));
		this.blit(ms, this.guiLeft + 34, this.guiTop + -18, 0, 0, 16, 16, 16, 16);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/scroll_table_3.png"));
		this.blit(ms, this.guiLeft + 58, this.guiTop + -27, 0, 0, 64, 32, 64, 32);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sobr:textures/knowledge_book.png"));
		this.blit(ms, this.guiLeft + 118, this.guiTop + -18, 0, 0, 16, 16, 16, 16);
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
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 56, 7, 20, new StringTextComponent("»"), e -> {
			if (true) {
				SobrMod.PACKET_HANDLER.sendToServer(new ScrollGUIGui.ButtonPressedMessage(0, x, y, z));
				ScrollGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
