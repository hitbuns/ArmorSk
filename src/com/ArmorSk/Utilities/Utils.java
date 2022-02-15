package com.ArmorSk.Utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static boolean isNullorAir(ItemStack itemStack) {
        return itemStack == null || itemStack.getType().equals(Material.AIR);
    }

    public static double RNG(int min,int max) {
        return Math.random()*(max-min)+min;
    }

    public static int RNG_INT(int min,int max) {
        return (int) Math.round(RNG(min, max));
    }

}
