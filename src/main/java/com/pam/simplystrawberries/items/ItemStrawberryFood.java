package com.pam.simplystrawberries.items;

import com.pam.simplystrawberries.Reference;
import com.pam.simplystrawberries.SimplyStrawberries;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStrawberryFood extends ItemFood{

	public ItemStrawberryFood(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName("strawberryitem");
	    setUnlocalizedName(Reference.MODID + ".strawberryitem");
	    setCreativeTab(SimplyStrawberries.modTab);
	}

	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
