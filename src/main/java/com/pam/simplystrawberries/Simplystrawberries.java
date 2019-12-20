package com.pam.simplystrawberries;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

import com.pam.simplystrawberries.Item.FoodRegistry;
import com.pam.simplystrawberries.Item.ItemRegistry;
import com.pam.simplystrawberries.block.BlockRegistry;
import com.pam.simplystrawberries.block.CropRegistry;
import com.pam.simplystrawberries.loottables.LootHandler;
import com.pam.simplystrawberries.setup.ModSetup;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Simplystrawberries.MODID)
public class Simplystrawberries
{

	public static final String MODID = "simplystrawberries";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static ModSetup setup = new ModSetup();
	
	
	@Nonnull
	public static ResourceLocation getId(String path) {
		return new ResourceLocation(MODID, path);
	}
	
	public Simplystrawberries() 
	{

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		CropRegistry.registerCrops();
        MinecraftForge.EVENT_BUS.register(new LootHandler());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(BlockRegistry::registerAll);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ItemRegistry::registerAll);
        MinecraftForge.EVENT_BUS.register(new FoodRegistry());
        //MinecraftForge.EVENT_BUS.register(new RightClickHarvesting());

    }

	private void setup(final FMLCommonSetupEvent event) {
        setup.init();
    }
	
	
	
	

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents 
    {

		
		
		
    }
    
}


