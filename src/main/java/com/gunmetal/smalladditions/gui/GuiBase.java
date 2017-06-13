package com.gunmetal.smalladditions.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import net.minecraft.client.gui.GuiScreen;

/** An abstract class that was created to define some common properties for all of the GUIs I want to create. <br>
 *  This includes things such as methods that need to be implemented, but it also includes things such as screen size. <br>
 *  This is convenient to have in a superclass, as it makes it easier to use. Also means I only need to implement it once. <br>
 *  
 * @author Lucas Crow / Gunmetal_Gears
 *
 */
public abstract class GuiBase extends GuiScreen {

	/** Does nothing. Is required for sub/superclass relationship.*/
	public GuiBase() {
	}
	
	/** A required variable. Appears to do nothing so it is set to zero. */
	public static final float TICKS = 0.0F;
	
	public abstract boolean doesGuiPauseGame();
	public abstract void initGui();
	
	//Everything below this is used to determine the screen size, and the center of said screen.
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	protected int screenHeight = (int) dim.getHeight();
	protected int screenWidth = (int) dim.getWidth();
	
	protected int centerX = screenWidth / 2;
	protected int centerY = screenHeight / 2;
	
	/** Used to pass along the baton of super.drawScreen() calls. Calling drawScreen() in GuiScreen is required to make GUIs work.
	 *  
	 *  @param mouseX The position the mouse is to be moved to when the GUI is opened.
	 *  @param mouseY The position the mouse is to be moved to when the GUI is opened.
	 *  @param partialTicks Does nothing. Required, but set to zero.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {super.drawScreen(mouseX, mouseY, partialTicks);}	
}
