package com.gunmetal.smalladditions.gui.addbook;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class UpdateNewsGui extends AddBookGui {
	
	@Override
	public void initGui() {
		this.buttonList.clear();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		int centerX = (this.width - 256) / 2;
		int centerY = (this.height - 256) / 2;
		this.drawDefaultBackground();
		
		this.mc.renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":" + "textures/gui/addbook.png"));
		drawTexturedModalRect(centerX, centerY, 0, 0, 256, 256); 
		this.drawCenteredString(mc.fontRendererObj, "Update News", centerX + 128, centerY + 50, WHITE);		
		
		
		super.drawScreen(0, 0, TICKS);
		this.mc.displayGuiScreen(this);
		
	}
}
