package com.ArmorSk.Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class ArmorEquipEvent extends ArmorEvent {

    private final ItemStack itemStack;

    public ArmorEquipEvent(String name, LivingEntity livingEntity, ItemStack equippedItem) {
        super(livingEntity, EquipType.EQUIP);
        this.itemStack = equippedItem;
    }

    public ArmorEquipEvent(LivingEntity livingEntity,ItemStack equippedItem) {
        super(livingEntity,EquipType.EQUIP);
        this.itemStack = equippedItem;
    }

    public ItemStack getEquippingItem() {
        return itemStack;
    }
}
