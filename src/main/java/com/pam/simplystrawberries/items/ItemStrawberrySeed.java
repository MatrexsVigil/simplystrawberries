package com.pam.simplystrawberries.items;

import com.pam.simplystrawberries.Reference;
import com.pam.simplystrawberries.SimplyStrawberries;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStrawberrySeed extends ItemSeeds {

	public ItemStrawberrySeed(Block crops, Block soil) {
		super(crops, soil);
		setRegistryName("strawberryseeditem");
	    setUnlocalizedName(Reference.MODID + ".strawberryseeditem");
	    setCreativeTab(SimplyStrawberries.modTab);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
