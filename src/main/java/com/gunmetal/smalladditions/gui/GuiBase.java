package com.gunmetal.smalladditions.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import net.minecraft.client.gui.GuiScreen;

public abstract class GuiBase extends GuiScreen {
	
	public GuiBase() {
	}
	
	public static final float TICKS = 0.0F;
	public static final int WHITE = 16777215;
	
	public abstract boolean doesGuiPauseGame();
	public abstract void initGui();
	
	public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenHeight = (int) dim.getHeight();
	public int screenWidth = (int) dim.getWidth();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {super.drawScreen(mouseX, mouseY, partialTicks);}	
}
