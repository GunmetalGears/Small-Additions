package com.gunmetal.smalladditions.gui;

import com.gunmetal.smalladditions.gui.addbook.AddBookGui;
import com.gunmetal.smalladditions.gui.addbook.UpdateNewsGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/** A class that directs the game to server-side or client-side GUI code. <br>
 *  This is used when GuiContainers are used. <br>
 *  GuiContainers are things such as chests; anything that has an inventory. <br>
 *  When a GuiContainer is interacted with, the container inventory is opened on the server side, and the GUI graphic is opened on the client side. <br>
 *  If the player takes anything from it, the server moves the item to the client's inventory. <br>
 *  
 * @author Lucas Crow / Gunmetal_Gears
 *
 */
public class SAGUIManager implements IGuiHandler {
	
	/** Normally this method returns a container that the server can access. This is so it can accept/give items to players that are interacting with it. <br>
	 *  I haven't done any work with GuiContainers, though, so it returns null. <br>
	 *  If I *were* doing work with GuiContainers, it would NEVER return null for any reason. <br>
	 *  
	 *  @param ID The integer ID of the container that is being opened.
	 *  @param player The player that is opening this container.
	 *  @param world Reference to the World object where this container is stored.
	 *  @param x X coordinate of the container.
	 *  @param y Y coordinate of the container.
	 *  @param z Z coordinate of the container.
	 */
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null; 
    }

	/** This method tells the player to display the correct graphic based on the ID of the GUI they are opening. <br>
	 *  This is used in conjunction with <code>getServerGuiElement()</code> when GuiContainers are used. <br>
	 *  
	 *  @param ID The integer ID of the container that is being opened.
	 *  @param player The player that is opening this container.
	 *  @param world Reference to the World object where this container is stored.
	 *  @param x X coordinate of the container.
	 *  @param y Y coordinate of the container.
	 *  @param z Z coordinate of the container.
	 */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case 0:
        	return new AddBookGui();
        case 1:
        	return new UpdateNewsGui();
        	
        case 2:
        	return null; //I have only made two GUIs at the time of writing this, so only two are available in this switch block.
        }
        return null;
    }
}
