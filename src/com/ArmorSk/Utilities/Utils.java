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

}
