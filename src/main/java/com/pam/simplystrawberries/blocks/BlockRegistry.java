package com.pam.simplystrawberries.blocks;

import java.util.ArrayList;
import java.util.List;

import com.pam.simplystrawberries.SimplyStrawberries;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public final class BlockRegistry {
	
	public static BlockStrawberryCrop strawberrycrop;
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
		strawberrycrop.initModel();
    }
}
