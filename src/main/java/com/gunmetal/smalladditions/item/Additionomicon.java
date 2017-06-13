package com.gunmetal.smalladditions.item;

import com.gunmetal.smalladditions.Main;
import com.gunmetal.smalladditions.gui.addbook.AddBookGui;
import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/** This class is for the Additionomicon item. In-game it is called 'Mod Guide' <br>
 *  It is a book, but right-clicking with it, while holding it, opens a GUI. <br>
 *  The GUI includes a graphic background, as well as several buttons.
 *  
 * @author Lucas Crow / Gunmetal_Gears
 *
 */
public class Additionomicon extends Item {
	public static final String NAME = "additionbook";
	
	//Instance of the book's GUI. Used for instantiation purposes.
	public static AddBookGui bookGui = new AddBookGui();
	
	/** Basic constructor. Sets several properties for the basic item that this book is.*/
	public Additionomicon() {
		super();
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
	}
	
	/** This method is called by Forge when the item is right clicked in hand. It is from <code>Item.class</code>, and it is used to open the GUI. <br>
	 */
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.openGui(Main.instance, 0, worldIn, 0, 0, 0);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn); 
	}
}
