package com.pam.simplystrawberries.blocks;

import com.pam.simplystrawberries.Reference;
import com.pam.simplystrawberries.SimplyStrawberries;
import com.pam.simplystrawberries.items.ItemRegistry;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStrawberryCrop extends BlockCrops 
{
	 public BlockStrawberryCrop() {
	        super();
	        setUnlocalizedName(Reference.MODID + ".strawberrycrop");
	        setRegistryName("strawberrycrop");
	        setCreativeTab(SimplyStrawberries.modTab);
	    }
	
	@Override
	protected Item getSeed()
    {
        return ItemRegistry.strawberryseeditem;
    }

	@Override
    protected Item getCrop()
    {
        return ItemRegistry.strawberryitem;
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
