package com.gunmetal.smalladditions.block;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** This class defines a basic block. <br>
 *  Its methods are used for gameplay physics and rendering purposes. <br>
 *  All of the Override annotations just mean that the methods *must* override something, else they cause a runtime error. <br>
 *  The SideOnly annotations are flags to the compiler for where the code should be run. <br>
 *  Client-side code, if it were run on a server, would cause crashes, and vice versa. <br>
 *  <br> 
 *  If you need comments to understand what the methods in this class do, please refer to GrassyStone.java. It has all the same methods, and they are documented there.
 * @author Lucas Crow / Gunmetal_Gears
 */
public class OreCinnabar extends Block {
	
	public static final String NAME = "orecinnabar";
	
	/** Defines some basic properties of the Block. <br>
	 *  This includes setting the sound type (stone, in this case), block hardness (how difficult it is to mine), and resistance (how much explosive force is required to break it).*/
	public OreCinnabar( ) {
		super(Material.ROCK);
		this.blockSoundType = SoundType.STONE;
		this.blockHardness = 2.0F;
		this.blockResistance = 15.0F;
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
		this.setRegistryName(Constants.MODID, NAME);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() { 
		return BlockRenderLayer.SOLID;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) { 
		return true;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) { 
		return EnumBlockRenderType.MODEL;
	}
}
