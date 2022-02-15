package com.ArmorSk.Events;

import com.ArmorSk.ArmorHandlers.ArmorType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class DisArmourEvent extends PlayerEvent implements Cancellable {

    private boolean cancel = false;
    public static HandlerList handlerList = new HandlerList();
    private final ArmorType armorType;
    private final ItemStack itemStack;

    public DisArmourEvent(Player who, ArmorType armorType, ItemStack itemStack) {
        super(who);
        this.armorType = armorType;
        this.itemStack = itemStack;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
