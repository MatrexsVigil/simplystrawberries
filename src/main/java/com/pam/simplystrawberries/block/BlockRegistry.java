package com.pam.simplystrawberries.block;

import javax.annotation.Nullable;

import com.pam.simplystrawberries.Simplystrawberries;
import com.pam.simplystrawberries.setup.ModSetup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
	
	public static Block strawberrycrop;
	
	public static void registerAll(RegistryEvent.Register<Block> event) {
		if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName()))
			return;
		
	
    		if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName()))
    			return;
    		
    		//strawberrycrop = register("strawberrycrop", new BlockSimplyCrop(Block.Properties.create(Material.PLANTS)
    		//		.doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.CROP), "strawberrycrop"));
	}
    	
		
		static <T extends Block> T register(String name, T block) {
			BlockItem item = new BlockItem(block, new Item.Properties().group(ModSetup.itemGroup));
			return register(name, block, item);
		}

		static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
			ResourceLocation id = Simplystrawberries.getId(name);
			block.setRegistryName(id);
			ForgeRegistries.BLOCKS.register(block);
			return block;
		}

}
