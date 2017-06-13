package com.gunmetal.smalladditions.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** The creative menu tab that Small Additions adds. <br>
 *  A creative tab is one of the tab sections in the creative-mode menu. <br>
 *  The SA one is intended to display everything the mod adds, for easier use of its features.
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 */
public class SACTab extends CreativeTabs {
	/** Designates the name of the tab. */
	public SACTab() {
		super("Small Additions");
	}
	
	/** Designates the item that is displayed as a label for the tab. */
	public Item getTabIconItem() {
		return SAItemManager.mercuryDrop;
	}

}
