package com.pam.simplystrawberries.loottables;

import com.pam.simplystrawberries.Simplystrawberries;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootHandler {
   
	private static ResourceLocation zombie_villager_drops = new ResourceLocation("minecraft", "entities/zombie_villager");

	@SubscribeEvent
	public void lootTableLoad(LootTableLoadEvent event) {
	
	if (event.getName().equals(zombie_villager_drops))
		event.getTable().addPool(LootPool.builder()
				.addEntry(
						TableLootEntry.builder(new ResourceLocation(Simplystrawberries.MODID, "entities/zombie_villager")))
				.name("sf_zombie_villager_drops").build());
}
}
