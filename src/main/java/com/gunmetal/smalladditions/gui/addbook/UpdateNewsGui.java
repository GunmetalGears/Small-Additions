package com.gunmetal.smalladditions.gui.addbook;

import org.lwjgl.opengl.GL11;

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
		GlStateManager.clear(GL11.GL_COLOR_BUFFER_BIT);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		int centerX = (this.width - 256) / 2;
		int centerY = (this.height - 256) / 2;
		this.mc.renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":" + "textures/gui/addbook.png"));
		drawTexturedModalRect(centerX, centerY + 50, 0, 0, 256, 256); 
		this.drawCenteredString(mc.fontRendererObj, "Update News", centerX + 128, centerY + 16, WHITE);		
		super.drawScreen(0, 0, TICKS);		
	}
	
//	@Override
//	public void actionPerformed(GuiButton button) {
//		switch (button.id) {
//		case 0: //update news
//			//this.mc.thePlayer.closeScreen();
//			this.mc.displayGuiScreen(new AddBookGui());
//			break;
//		case 1:
//			//do something with button id 1 here
//		case 2:
//			//button 2
//		case 3: 
//			//etc...
//		}
//	}
}
