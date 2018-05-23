package com.pam.simplystrawberries.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pam.simplystrawberries.SimplyStrawberries;
import com.pam.simplystrawberries.blocks.BlockRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public final class ItemRegistry {

	    public static ItemStrawberrySeed strawberryseeditem;
	    public static ItemStrawberryFood strawberryitem;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	strawberryseeditem.initModel();
    	strawberryitem.initModel();
    }

}
