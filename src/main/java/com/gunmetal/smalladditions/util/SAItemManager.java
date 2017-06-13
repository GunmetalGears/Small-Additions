package com.gunmetal.smalladditions.util;

import com.gunmetal.smalladditions.item.Additionomicon;
import com.gunmetal.smalladditions.item.MercuryDrop;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.UniversalBucket;

/** A sort of 'hub' for Items in Small Additions. This includes ItemBlocks. <br>
 *  Items in Small Additions are always the same objects; they are copies, if not direct references to, these stored objects. <br>
 *  This is a more efficient method of item handling than creating new objects on the fly. <br>
 *  The Minecraft garbage collector isn't very efficient, so saving memory space as much as possible is very, very important. <br>
 *  A generally good practice to keep in mind is that the lighter weight a program or mod is, the better.
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 *
 */
public class SAItemManager {
	
	/** Takes care of some bucket tomfoolery. I could've done this in its own class, but that would be significantly more in-depth than it needed to be. */
	public static void registerItems() {
		HgBucket = new UniversalBucket(1000, new ItemStack(Items.BUCKET), false);
		HgBucket.setRegistryName("mercurybucket");
		HgBucket.setUnlocalizedName("mercurybucket");
	}
	
	public static MercuryDrop mercuryDrop = new MercuryDrop();
	public static ItemBlock gStoneItem = new ItemBlock(SABlockManager.grassystone);
	public static ItemBlock cOreItem = new ItemBlock(SABlockManager.orecinnabar);
	public static UniversalBucket HgBucket;
	public static Additionomicon additionbook = new Additionomicon();
}
