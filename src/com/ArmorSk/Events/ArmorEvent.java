package com.ArmorSk.Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class ArmorEvent extends Event implements Cancellable {

    private boolean cancel = false;
    public static HandlerList handlerList = new HandlerList();
    private final LivingEntity livingEntity;
    private final EquipType equipType;

    public ArmorEvent(LivingEntity livingEntity,EquipType equipType) {
        this.livingEntity = livingEntity;
        this.equipType = equipType;
    }

    public EquipType getEquipType() {
        return equipType;
    }

    public enum EquipType {

        UNEQUIP(),
        EQUIP(),
        BOTH()
        ;

    }

    public LivingEntity getLivingEntity() {
        return livingEntity;
    }

    @Override
    public boolean isCancelled() {
        return this.cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = b;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
