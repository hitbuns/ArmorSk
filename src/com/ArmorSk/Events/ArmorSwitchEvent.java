package com.ArmorSk.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class ArmorSwitchEvent extends ArmorEvent {


    private final ItemStack equippingItem;
    private final ItemStack unequippingItem;

    public ArmorSwitchEvent(String name, LivingEntity livingEntity, ItemStack equippingItem,ItemStack unequippingItem) {
        super(livingEntity, EquipType.BOTH);
        this.equippingItem = equippingItem;
        this.unequippingItem = unequippingItem;
    }

    public ArmorSwitchEvent(LivingEntity livingEntity, ItemStack equippingItem,ItemStack unequippingItem) {
        super(livingEntity,EquipType.BOTH);
        this.equippingItem = equippingItem;
        this.unequippingItem = unequippingItem;
    }

    public ArmorSwitchEvent invoke() {
        ArmorUnEquipEvent armorUnEquipEvent = new ArmorUnEquipEvent(this.getLivingEntity(),this.unequippingItem);
        Bukkit.getPluginManager().callEvent(armorUnEquipEvent);
        if (armorUnEquipEvent.isCancelled()) {
            this.setCancelled(true);
            return this;
        }
        ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(this.getLivingEntity(),this.equippingItem);
        Bukkit.getPluginManager().callEvent(armorEquipEvent);
        this.setCancelled(armorEquipEvent.isCancelled());
        return this;
    }

    public ItemStack getEquippingItem() {
        return equippingItem;
    }

    public ItemStack getUnequippingItem() {
        return unequippingItem;
    }
}
