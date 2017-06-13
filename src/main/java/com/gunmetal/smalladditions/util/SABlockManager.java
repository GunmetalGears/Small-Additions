package com.gunmetal.smalladditions.util;

import java.util.ArrayList;

import com.gunmetal.smalladditions.block.GrassyStone;
import com.gunmetal.smalladditions.block.OreCinnabar;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/** This class designates a sort of 'hub' for all the blocks in the mod Small Additions. <br>
 *  It creates a list that contains all the blocks in the mod. It also registers them automatically. <br>
 *  DO NOT REGISTER SA BLOCKS OUTSIDE OF THIS CLASS!
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 */
public class SABlockManager {
	public static GrassyStone grassystone = new GrassyStone();
	public static OreCinnabar orecinnabar = new OreCinnabar();
	
	public static ArrayList<Block> modblocks = new ArrayList<Block>();
	
	public static void addBlocks() {
		modblocks.add(grassystone);
		modblocks.add(orecinnabar);
	}
	
	/** Still working on this method. It is intended to run through the list of blocks currently in the mod and register all of them.
	 */
	public static void registerBlocks() {
		addBlocks();
		for (int i = 0; i < modblocks.size(); i++) {
			//modblocks.get(i).setRegistryName(Constants.MODID, modblocks.get(i).getName()); #TODO
			GameRegistry.register(modblocks.get(i));
		}
	}
}
