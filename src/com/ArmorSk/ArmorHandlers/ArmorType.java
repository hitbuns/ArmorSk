package com.ArmorSk.ArmorHandlers;

import org.bukkit.enchantments.EnchantmentTarget;

public enum ArmorType {

    HELMET(39,EnchantmentTarget.ARMOR_HEAD),
    CHESTPLATE(38,EnchantmentTarget.ARMOR_TORSO),
    LEGGINGS(37,EnchantmentTarget.ARMOR_LEGS),
    BOOTS(36,EnchantmentTarget.ARMOR_FEET)
    ;

    ArmorType(int slot, EnchantmentTarget enchantmentTarget) {
        this.slot = slot;
        this.enchantmentTarget = enchantmentTarget;
    }

    private final EnchantmentTarget enchantmentTarget;
    private final int slot;

    public EnchantmentTarget getEnchantmentTarget() {
        return enchantmentTarget;
    }

    public int getSlot() {
        return slot;
    }
}
