package com.ArmorSk.EventListener;

import com.ArmorSk.ArmorHandlers.ArmorType;
import com.ArmorSk.Events.ArmorEquipEvent;
import com.ArmorSk.Utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements Listener {


    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (!e.getAction().name().contains("RIGHT_CLICK") || Utils.isNullorAir(e.getItem())) return;
        for (ArmorType armorType : ArmorType.values()) {
            if (armorType.getEnchantmentTarget().includes(e.getItem()) &&
                    Utils.isNullorAir(e.getPlayer().getInventory().getItem(armorType.getSlot()))) {
                ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(e.getPlayer(),e.getItem());
                Bukkit.getPluginManager().callEvent(armorEquipEvent);
                e.setCancelled(armorEquipEvent.isCancelled());
                break;
            }
        }
    }


}
