package com.gunmetal.smalladditions.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

/** Manages all of the physical models in the mod. This sort of includes textures. 
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 *
 */
public class SAModelManager {
	public static final SAModelManager INSTANCE = new SAModelManager();
	private static final String FLUID_RESOURCE_PATH = Constants.RESOURCE_PREFIX + "fluid";
	
	/** Does nothing. Required for some reason. */
	private SAModelManager() {
		
	}
	
	/** Again, does nothing, but is required. */
	public void registerFluidModels(Fluid fluid) {
		
	}
	
	/** This actually does something. It makes sure the item it's given isn't null, and then if it isn't, it does its best to fill a bucket.
	 *  At least, that's what I think it does. The Minecraft fluid system is obscenely complicated and abstract, and is extremely difficult to follow.
	 *  
	 *  @param fluidBlock
	 */
	public void registerFluidModel(BlockFluidBase fluidBlock) {
		final Item item = Item.getItemFromBlock(fluidBlock);
		assert item != null;
		ModelBakery.registerItemVariants(item);
		final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(FLUID_RESOURCE_PATH, fluidBlock.getFluid().getName());
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return modelResourceLocation;
			}
		});
		ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
				return modelResourceLocation;
			}
		});
	}
}
