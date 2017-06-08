package com.gunmetal.smalladditions.gui.addbook;

import com.gunmetal.smalladditions.gui.GuiBase;
import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class AddBookGui extends GuiBase {
	protected int centerX = screenHeight / 2;
	protected int centerY = screenHeight / 2;
	
	public AddBookGui() {
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, 256, 100, 180, 20, "x: " + centerX + " y: " + centerY));
		this.buttonList.add(new GuiButton(1, 256, 150, 180, 20, "Natural Creations"));
		this.buttonList.add(new GuiButton(2, 256, 200, 180, 20, "Simple Constructions"));
		this.buttonList.add(new GuiButton(3, 256, 250, 180, 20, "Advanced Constructs"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.drawDefaultBackground();
		this.mc.renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":" + "textures/gui/addbook.png"));
		drawTexturedModalRect(centerX, centerY + 300, 0, 0, 256, 256); 
		this.drawCenteredString(mc.fontRendererObj, "Additionomicon", centerX + 128, centerY + 16, WHITE);				
		super.drawScreen(0, 0, TICKS);
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0: 
			this.mc.displayGuiScreen(new UpdateNewsGui());
			break;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}