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
 * @author Lucas Crow / Gunmetal_Gears
 */
public class GrassyStone extends Block {
	
	private final String NAME = "grassystone";
	
	/** Defines some basic properties of the Block. <br>
	 *  This includes setting the sound type (stone, in this case), block hardness (how difficult it is to mine), and resistance (how much explosive force is required to break it).*/
	public GrassyStone() { 
		super(Material.ROCK);
		this.blockSoundType = SoundType.STONE;
		this.blockHardness = 1.5F;
		this.blockResistance = 10.0F;
		this.setCreativeTab(Constants.SACTAB);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(Constants.MODID, NAME);
	}
	
	/** Self explanatory. Required for properties such as redstone and light calculation.*/
	@Override 
	public boolean isOpaqueCube(IBlockState iBlockState) { 
		return true;
	}
	
	/** Defines the way in which this block is rendered (which is only done client-side). <br>
	 *  In this case, it is rendered as a solid. Otherwise, it could also be translucent, or have parts of its texture missing (to make them not appear).*/
	@SideOnly(Side.CLIENT) 
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}
	
	/** Defines this block as a solid, full cube. Non-cube blocks would be things such as stairs or fences. <br>
	 *  This is needed to determine certain properties. It goes with <code>isOpaqueCube().</code> */
	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return true;
	}
	
	/** This method doesn't really do anything. <br>
	 *  EnumBlockRenderTypes don't really do anything, either. <br>
	 *  Minecraft is full of redundant, seemingly useless methods and render tidbits like this. <br>
	 *  But it is necessary for some reason. The block doesn't work without it. Don't ask me why, I don't know.  */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) { 
		return EnumBlockRenderType.MODEL;
	}
}
