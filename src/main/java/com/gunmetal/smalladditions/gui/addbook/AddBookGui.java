package com.gunmetal.smalladditions.gui.addbook;

import com.gunmetal.smalladditions.gui.GuiBase;
import com.gunmetal.smalladditions.util.ColorUtils;
import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** The main GUI of the Additionomicon item. <br>
 *  It displays a textured rectangle and several buttons.
 *  
 * @author Lucas Crow / Gunmetal_Gears
 *
 */
@SideOnly (Side.CLIENT)
public class AddBookGui extends GuiBase {
	
	//These fields are inherited from GuiBase, but due to the way the compiler handles Minecraft class loading, they need to be re-defined here.
	protected int centerX = screenWidth / 2;
	protected int centerY = screenHeight / 2;
	int texX;
	int texY;
	
	/** Not really used, but resetting these fields to zero is required due to compile-time class loading.
	 *  
	 */
	public AddBookGui() {
		texX = 0;
		texY = 0;
	}
	
	/** This method is called to initialize any significant GUI elements that are to be interacted with. <br>
	 *  In this case, that means GuiButtons.
	 *  
	 */
	@Override
	public void initGui() {
		texX = (width - 128);
		texY = (height - 128);
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, texX, texY, 180, 20, "Update News"));
		this.buttonList.add(new GuiButton(1, texX, texY + 50, 180, 20, "Natural Creations"));
		this.buttonList.add(new GuiButton(2, texX, texY + 100, 180, 20, "Simple Constructions"));
		this.buttonList.add(new GuiButton(3, texX, texY + 150, 180, 20, "Advanced Constructs"));
	}
	
	/** Called to set up the elements of the GUI that need to be manually drawn by the game (such as the background). <br>
	 *  This sets up a ton of stuff and would require so much commenting to explain that it is impractical. <br>
	 *  The best I can do is say "it works, and I know why, but I don't know how to explain it." <br>
	 *  
	 *  @param mouseX Where the mouse cursor is to be moved to when the GUI is opened.
	 *  @param mouseY Where the mouse cursor is to be moved to when the GUI is opened.
	 *  @param partialTicks Does nothing. Required for some reason.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		texX = (width - 256) / 2;
		texY = (height - 256) / 2;
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.drawDefaultBackground();
		this.mc.renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":" + "textures/gui/addbook.png"));
		drawTexturedModalRect(texX, texY, 0, 0, 256, 256); 
		this.drawCenteredString(mc.fontRendererObj, "Additionomicon", centerX + 128, centerY + 16, ColorUtils.WHITE);	
		this.drawCenteredString(mc.fontRendererObj, "tX: " + texX + " tY: " + texY, texX, texY, ColorUtils.RED);
		AddBookGui.drawRect(texX, texY, texX + 1, texY + 1, ColorUtils.BLUE);
		super.drawScreen(0, 0, TICKS);
	}
	
	/** Called when a button is clicked. Can also be called by custom-made elements of the GUI, if one were to make some.
	 *  
	 *  @param button The button that called this method.
	 */
	@Override
	public void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0: 
			this.mc.displayGuiScreen(new UpdateNewsGui());
			break;
		}
	}
	
	/** Whether or not having this GUI open pauses the game. (only effective in singleplayer; does nothing and isn't used in multiplayer).
	 *  
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}