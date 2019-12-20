package com.pam.simplystrawberries.Item;

import net.minecraft.item.Food;

public class FoodRegistry {
	
	public static final Food strawberryitem = (new Food.Builder()).hunger(2).saturation(0.6F).build();
	public static final Food strawberrymelonsaladitem = (new Food.Builder()).hunger(6).saturation(7.2F).build();
	public static final Food strawberrymilkshakeitem = (new Food.Builder()).hunger(6).saturation(4.8F).build();

}
