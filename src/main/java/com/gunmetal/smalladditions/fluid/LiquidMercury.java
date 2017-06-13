package com.gunmetal.smalladditions.fluid;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** This class represents a physical liquid block that can be rendered and interacted with in the Minecraft world. <br>
 *  It has nothing to do with buckets, fluids in tanks or bottles, or anything of the sort. <br>
 *  A fluid is different from a liquid. <br>
 *  A fluid is to an item as a liquid is to a block. <br>
 *  This one defines the physical properties of Liquid Mercury, a gray metallic liquid. <br>
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 */
public class LiquidMercury extends BlockFluidClassic implements IFluidBlock {
	
	/** Constructor to define some basic properties. <br>
	 *  This includes things like an unlocalized name (used for language translations), a registry name (used while compiling), and the creative tab it is displayed in. <br>
	 *  
	 * @param fluid The fluid that this liquid corresponds with.
	 */
	public LiquidMercury(Fluid fluid) {
		super(fluid, new MaterialLiquid(MapColor.SILVER));
		this.setUnlocalizedName(Constants.RESOURCE_PREFIX + "liquid_mercury");
		this.setRegistryName("liquid_mercury");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	//********************//
	// BLOCK METHODS START//
	//********************//
	//These methods are exactly the same as those defined in GrassyStone.java. Refer to those if you need documentation for these.
	
	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}
	
	//*******************//
	// BLOCK METHODS END //
	//*******************//
	
	/** Returns the fluid associated with this Liquid. */
	@Override
	public Fluid getFluid() {
		return definedFluid;
	}
	
	/** My attempt at making Minecraft liquid physics work. I don't actually know how they work, as they aren't defined anywhere, so this is a temporary hack. <br>
	 *  Any entity that enters this block is slowed to 10% normal speed, horizontally. Vertically, they are not slowed at all. <br>
	 *  This method is called when an entity collides with the block (colliding is defined as entering into it or touching it). <br>
	 *  
	 *  @param world Reference to the World object this block is stored in.
	 *  @param pos Where in the world the block is stored. Also stores what is around it.
	 *  @param state What state the block is in.
	 *  @param entity The entity that is colliding with this block.
	 */
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {  
	        entity.motionX *= 0.1D;
	        entity.motionZ *= 0.1D;
	    }
	 
	/** This method is required to make buckets work. Even though it has no implementation, it has to exist. Don't ask me why, I don't know. <br>
	 *  It is called a player right clicks on it.
	 *  
	 *  @param worldIn Reference to the World object that this block is stored in.
	 *  @param pos The position of this block in the world. Also keeps track of other blocks around it.
	 *  @param playerIn The player that clicked on this block. This is used to get the items the player is holding, or to interact with them.
	 */
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (playerIn.getHeldEquipment().equals(Items.BUCKET)) {
			
		}
	}
}
