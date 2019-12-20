package com.pam.simplystrawberries.block;

import java.text.MessageFormat;
import java.util.HashMap;

import com.pam.simplystrawberries.Item.FoodRegistry;
import com.pam.simplystrawberries.Item.ItemRegistry;
import com.pam.simplystrawberries.Item.SimplySeed;
import com.pam.simplystrawberries.block.growables.BlockSimplyCrop;
import com.pam.simplystrawberries.setup.ModSetup;

import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class CropRegistry {

	public static final String CROP_BLOCK_NAME = "{0}crop";
	public static final String ITEM_NAME = "{0}item";
	public static final String SEED_ITEM_NAME = "{0}seeditem";

	public static final String STRAWBERRY = "strawberry";


	public static final String[] cropNames = new String[] {STRAWBERRY};

	private static boolean isInitialized = false;

	private static final HashMap<String, SimplySeed> seeds = new HashMap<String, SimplySeed>();
	private static final HashMap<String, BlockNamedItem> foods = new HashMap<String, BlockNamedItem>();

	private static final HashMap<String, BlockSimplyCrop> crops = new HashMap<String, BlockSimplyCrop>();

	public static HashMap<String, SimplySeed> getSeeds() {
		return seeds;
	}

	public static HashMap<String, BlockNamedItem> getFoods() {
		return foods;
	}

	public static HashMap<String, BlockSimplyCrop> getCrops() {
		return crops;
	}

	public static boolean isInitialized() {
		return isInitialized;
	}

	public static Item getSeed(String cropName) {

		return seeds.get(cropName);
	}

	public static BlockNamedItem getFood(String cropName) {

		return foods.get(cropName);
	}

	public static BlockSimplyCrop getCrop(String cropName) {

		return crops.get(cropName);
	}

	public static void registerCrops() {
		if(isInitialized)
			return;

		for(String cropName : cropNames) {
			registerCrop(cropName);
		}

		isInitialized = true;
	}

	private static void registerCrop(String cropName) {
		final String registryName = MessageFormat.format(CROP_BLOCK_NAME, cropName);
		final BlockSimplyCrop cropBlock = new BlockSimplyCrop(Properties.create(Material.LEAVES).doesNotBlockMovement().sound(SoundType.CROP).tickRandomly(), registryName, cropName);

		BlockRegistry.register(registryName, cropBlock);

		final BlockNamedItem item = createItem(cropBlock);
		ItemRegistry.register(MessageFormat.format(ITEM_NAME, cropName), item);
		cropBlock.setFood(item);

		final SimplySeed seedItem = createSeed(cropBlock);
		ItemRegistry.register(getSeedName(cropName), seedItem);
		cropBlock.setSeed(seedItem);

		seeds.put(cropName, seedItem);
		foods.put(cropName, item);
		crops.put(cropName, cropBlock);
	}


	private static String getSeedName(String cropName) {

		return MessageFormat.format(SEED_ITEM_NAME, cropName);
	}

	private static BlockNamedItem createItem(BlockSimplyCrop cropBlock) {
		return new BlockNamedItem(cropBlock, new Item.Properties().food(FoodRegistry.strawberryitem).group(ModSetup.itemGroup));
	}

	private static SimplySeed createSeed(BlockSimplyCrop cropBlock) {
		return new SimplySeed(cropBlock, new Item.Properties().group(ModSetup.itemGroup));
	}
}