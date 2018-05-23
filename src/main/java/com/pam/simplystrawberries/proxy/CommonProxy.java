package com.pam.simplystrawberries.proxy;

import com.pam.simplystrawberries.blocks.BlockRegistry;

import com.pam.simplystrawberries.blocks.BlockStrawberryCrop;
import com.pam.simplystrawberries.items.ItemRegistry;
import com.pam.simplystrawberries.items.ItemStrawberryFood;
import com.pam.simplystrawberries.items.ItemStrawberrySeed;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {  
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockStrawberryCrop());
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemStrawberrySeed(BlockRegistry.strawberrycrop, Blocks.FARMLAND));
        event.getRegistry().register(new ItemStrawberryFood(1, 1.2F, false));
    }
}
