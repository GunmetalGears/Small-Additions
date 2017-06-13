package com.gunmetal.smalladditions.util;

import com.gunmetal.smalladditions.fluid.LiquidMercury;

import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/** A sort of 'hub' for fluids in Small Additions. This class is extremely complicated in its workings. <br>
 *  It may not appear it, but it was exceedingly difficult to get all this BS working. <br>
 *  My comments here are my best attempt at explaining how this class functions. <br>
 *  The methods here are implemented in a way that may appear strange, such as being passed identical parameters with different names. <br>
 *  This is intentional. Abstracting method functionality to make them more flexible is very useful if more fluids were to be added later. <br>
 *  
 *  @author Lucas Crow / Gunmetal_Gears
 *
 */
public class SAFluidManager {
	
	//A couple of stored objects that are used as reference points.
	public static Fluid fluidMercury;
	public static BlockFluidBase liquidMercury;
	
	/** A 'main method' of sorts. It initializes the liquid variable of the class and calls the actual registry methods. */
	public static void register() {
		registerFluids();
		liquidMercury = new LiquidMercury(fluidMercury);
		registerFluidBlock(liquidMercury);
	}
	
	/** Begins the registry process for the fluids. Initializes the fluid variable and then actually registers it with the Forge Fluid Registry. */
	public static void registerFluids() {
		fluidMercury = createFluid("liquid_mercury", "liquid_mercury", true);
		FluidRegistry.registerFluid(fluidMercury);
		setBucketforFluids(fluidMercury);
	}
	
	/** Similar to <code>registerFluidBlock()</code>, in that it registers SA liquids. The main differences are that this method is registering a liquid, not a fluid.
	 * Also, it is using the Game Registry, not the Fluid Registry. */
	public static void registerFluidBlock(BlockFluidBase input) {
		String fluidName = input.getFluid().getUnlocalizedName();
		input.setUnlocalizedName(fluidName);
		GameRegistry.register(input);
		GameRegistry.register(new ItemBlock(input).setRegistryName(input.getRegistryName()));
	}
	
	/** This method is largely for texture and model assignments. It looks for, and assigns, textures to liquid blocks on the fly. */
	public static Fluid createFluid(String name, String textureName, boolean hasFlowIcon) {
		String texturePrefix = Constants.RESOURCE_PREFIX + "blocks/";
		ResourceLocation still = new ResourceLocation(texturePrefix + textureName + "_still");
		ResourceLocation flowing;
		if (hasFlowIcon) {
			flowing = new ResourceLocation(texturePrefix + textureName + "_flow");
		} else {
			flowing = still;
		}
		Fluid fluid = new Fluid(name, still, flowing);
		return fluid;
	}
	
	/** This is fairly self explanatory. It sets the bucket for the fluid it's given. */
	public static void setBucketforFluids(Fluid fluid) {
		FluidRegistry.addBucketForFluid(fluid);
	}
}
