package com.pam.simplystrawberries.Item;


import com.pam.simplystrawberries.Simplystrawberries;
import com.pam.simplystrawberries.setup.ModSetup;

import net.minecraft.item.Item;
import net.minecraft.item.SoupItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
	
	public static Item strawberryitem;
	public static Item strawberryseeditem;
	public static Item strawberrymelonsalditem;
	public static Item strawberrymilkshakeitem;
	
	public static void registerAll(RegistryEvent.Register<Item> event) {
		if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName()))
			return;
		
		strawberrymelonsalditem = register("strawberrymelonsaladitem", new SoupItem(new Item.Properties().food(FoodRegistry.strawberrymelonsaladitem).maxStackSize(1).group(ModSetup.itemGroup)));
		strawberrymilkshakeitem = register("strawberrymilkshakeitem", new Item(new Item.Properties().food(FoodRegistry.strawberrymilkshakeitem).group(ModSetup.itemGroup)));
		//strawberryitem = register("strawberryitem", new BlockNamedItem(BlockRegistry.strawberrycrop, new Item.Properties().food(FoodRegistry.strawberryitem).group(ModSetup.itemGroup)));
		//strawberryseeditem = register("strawberryseeditem", new SimplySeed(BlockRegistry.strawberrycrop, new Item.Properties().group(ModSetup.itemGroup)));
	}


	public static Item register(String name, Item item) {
		ResourceLocation id = Simplystrawberries.getId(name);
		item.setRegistryName(id);
		ForgeRegistries.ITEMS.register(item);
		return item;
	}


	static Item register(String name, SoupItem soupItem) {
		ResourceLocation id = Simplystrawberries.getId(name);
		soupItem.setRegistryName(id);
		ForgeRegistries.ITEMS.register(soupItem);
		return soupItem;
	}




}
