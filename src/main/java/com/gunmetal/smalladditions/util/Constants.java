package com.gunmetal.smalladditions.util;

import net.minecraft.util.ResourceLocation;

/** This class stores some useful constant variables that come in handy during normal Forge use. <br>
 *  This includes commonly used strings (such as the mod name or version), but also includes instantiated objects. <br>
 *  A list like this would be much larger if the mod itself were larger.
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 *
 */
public class Constants {
	public static final String MODNAME = "Small Additions";
	public static final String VERSION = "1.1";
	public static final String MODID = "smalladditions";
	public static final ResourceLocation RESOURCE_PREFIX = new ResourceLocation(MODID + ":");
	public static final SACTab SACTAB = new SACTab();
}
