package com.pam.simplystrawberries.setup;

import com.pam.simplystrawberries.Item.ItemRegistry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ModSetup {

    public static final ItemGroup itemGroup = new ItemGroup("tabSimplyStrawberries") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.strawberryitem);
        }
    };

    public void init() {

    }

}
