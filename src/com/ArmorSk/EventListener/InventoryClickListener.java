package com.ArmorSk.EventListener;

import com.ArmorSk.ArmorHandlers.ArmorType;
import com.ArmorSk.Events.ArmorEquipEvent;
import com.ArmorSk.Events.ArmorEvent;
import com.ArmorSk.Events.ArmorSwitchEvent;
import com.ArmorSk.Events.ArmorUnEquipEvent;
import com.ArmorSk.Utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {


    @EventHandler (priority = EventPriority.LOWEST)
    public void onArmorEquipment(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        for (ArmorType armorType : ArmorType.values()) {
            if (e.getSlot() == armorType.getSlot()) {
                ArmorEvent armorEvent;
                ItemStack equippingItem = (e.getHotbarButton() == -1) ?
                e.getCursor() : e.getClickedInventory().getItem(e.getHotbarButton());
                if (!(Utils.isNullorAir(e.getCurrentItem()) || Utils.isNullorAir(equippingItem)))
                    Bukkit.getPluginManager().callEvent(armorEvent = new ArmorSwitchEvent(p,equippingItem,e.getCurrentItem()).invoke());
                else if (!(Utils.isNullorAir(equippingItem)) && armorType.getEnchantmentTarget().includes(equippingItem))
                    Bukkit.getPluginManager().callEvent(armorEvent = new ArmorEquipEvent(p,equippingItem));
                else if (!Utils.isNullorAir(e.getCurrentItem()))
                    Bukkit.getPluginManager().callEvent(armorEvent = new ArmorUnEquipEvent(p,e.getCurrentItem()));
                else return;
                e.setCancelled(armorEvent.isCancelled());
                break;
            } else if (Utils.isNullorAir(e.getClickedInventory().getItem(armorType.getSlot())) && (e.getClick().equals(ClickType.SHIFT_LEFT)
            || e.getClick().equals(ClickType.SHIFT_RIGHT)) && armorType.getEnchantmentTarget().includes(e.getCurrentItem())) {
                ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p,e.getCurrentItem());
                Bukkit.getPluginManager().callEvent(armorEquipEvent);
                e.setCancelled(armorEquipEvent.isCancelled());
                break;
            }
        }
    }



}
