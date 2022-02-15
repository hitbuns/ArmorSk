package com.ArmorSk.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddItemToInventoryEvent extends PlayerEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final List<ItemStack> itemStacks;
    private boolean cancel = false;
    private ItemStack[] itemStackArray;

    public AddItemToInventoryEvent(Player who, ItemStack... itemStacks) {
        super(who);
        this.itemStacks = itemStacks != null ? Arrays.asList(itemStacks) : new ArrayList<>();
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public List<ItemStack> getItemStacks() {
        return itemStacks;
    }

    public ItemStack[] getItemStackArray() {
        return itemStackArray;
    }

    public AddItemToInventoryEvent build() {
        itemStackArray = itemStacks.toArray(new ItemStack[0]);
        return this;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
