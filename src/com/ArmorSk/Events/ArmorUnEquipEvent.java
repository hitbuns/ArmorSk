package com.ArmorSk.Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class ArmorUnEquipEvent extends ArmorEvent{


    private final ItemStack unequippedItem;

    public ArmorUnEquipEvent(String name, LivingEntity livingEntity, ItemStack unequippedItem) {
        super(livingEntity, EquipType.UNEQUIP);
        this.unequippedItem = unequippedItem;
    }

    public ArmorUnEquipEvent(LivingEntity livingEntity,ItemStack unequippedItem) {
        super(livingEntity,EquipType.UNEQUIP);
        this.unequippedItem = unequippedItem;
    }

    public ItemStack getUnequippedItem() {
        return unequippedItem;
    }
}
