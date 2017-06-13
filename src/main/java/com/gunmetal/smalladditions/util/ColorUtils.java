package com.gunmetal.smalladditions.util;

/** This class is used mostly by the GUI classes, but it can find use elsewhere as well. <br>
 *  It stores some pre-calculated RGB integer values. <br>
 *  Minecraft interprets colors as RGB ints, which are 7-bit numbers that dictate the red, green, blue, and alpha values. <br>
 *  They are stored here in case they are needed. They were calculated using an online tool: https://www.shodor.org/stella2java/rgbint.html
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 *
 */
public class ColorUtils {
	
	public static final int WHITE = 16777215;
	public static final int BLACK = 0;
	
	public static final int GUI_BG = 13027014;
	
	public static final int RED = 16711680;
	public static final int GREEN = 65280;
	public static final int BLUE = 255;
}
