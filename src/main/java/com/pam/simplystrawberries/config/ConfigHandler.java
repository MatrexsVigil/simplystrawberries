package com.pam.simplystrawberries.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    private final Configuration config;

    private static final String CATEGORY_GENERAL = "general";

public ConfigHandler(Configuration config) {
        this.config = config;

        initSettings();
    }

    private void initSettings() {
        config.load();

        initGeneralSettings();

        if (config.hasChanged()) {
            config.save();
        }
    }

    private void initGeneralSettings() {

    }

}
