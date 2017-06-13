package com.gunmetal.smalladditions.item;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.item.Item;

/** This class is for the Drop of Mercury item. It doesn't really implement any methods or special functionality because it doesn't do anything special or interesting.
 * 
 * @author Lucas Crow / Gunmetal_Gears
 */
public class MercuryDrop extends Item {
	
	public static final String NAME = "mercurydrop";
	
	/** Sets some basic properties of this Item */
	public MercuryDrop() {
		super();
		this.maxStackSize = 64;
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
	}
	
	public String getName() {
		return NAME;
	}
}
