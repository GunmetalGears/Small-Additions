package com.gunmetal.smalladditions.gui;

import com.gunmetal.smalladditions.gui.addbook.AddBookGui;
import com.gunmetal.smalladditions.gui.addbook.UpdateNewsGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class SAGUIManager implements IGuiHandler {
	
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null; //if I were using containers in GUIs then this would NOT return null for any reason, ever
        			 //but I'm not so it does
    }

	
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case 0:
        	return new AddBookGui();
        	
        case 1:
        	return new UpdateNewsGui();
        	
        case 2:
        	return null;
        }
        return null;
    }
}
