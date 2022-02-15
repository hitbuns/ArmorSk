package com.ArmorSk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.ArmorSk.EventListener.InventoryClickListener;
import com.ArmorSk.EventListener.RightClickListener;
import com.ArmorSk.Events.ArmorEquipEvent;
import com.ArmorSk.Events.ArmorEvent;
import com.ArmorSk.Events.ArmorUnEquipEvent;
import com.ArmorSk.Events.DisArmourEvent;
import com.ArmorSk.Skript.Effects.EffDisarmor;
import com.ArmorSk.Skript.Events.EvtArmorEquip;
import com.ArmorSk.Skript.Events.EvtArmorUnEquip;
import com.ArmorSk.Skript.Events.EvtDisArmor;
import com.ArmorSk.Utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public SkriptAddon addon;

    @Override
    public void onEnable() {
        addon = Skript.registerAddon(this);
        Bukkit.getConsoleSender().sendMessage(Utils.color("&c[ArmorSK] &ePlugin has been &a&lENABLED"));
        registerEvents();
        registerSkriptEvents();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(),this);
        this.getServer().getPluginManager().registerEvents(new RightClickListener(),this);
    }

    private void registerSkriptEvents() {

        Skript.registerEvent("Armor Equip", EvtArmorEquip.class, ArmorEquipEvent.class,"[armor] equip");
        Skript.registerEvent("Armor UnEquip", EvtArmorUnEquip.class, ArmorUnEquipEvent.class,"[armor] unequip");
        Skript.registerEvent("DisArmor", EvtDisArmor.class, DisArmourEvent.class,"disarmor");
        EventValues.registerEventValue(ArmorEvent.class, LivingEntity.class, new Getter<LivingEntity, ArmorEvent>() {
            @Override
            public LivingEntity get(ArmorEvent armorEvent) {
                return armorEvent.getLivingEntity();
            }
        },0);
        EventValues.registerEventValue(ArmorEquipEvent.class, ItemStack.class, new Getter<ItemStack, ArmorEquipEvent>() {
            @Override
            public ItemStack get(ArmorEquipEvent armorEquipEvent) {
                return armorEquipEvent.getEquippingItem();
            }
        },0);
        EventValues.registerEventValue(ArmorUnEquipEvent.class, ItemStack.class, new Getter<ItemStack, ArmorUnEquipEvent>() {
            @Override
            public ItemStack get(ArmorUnEquipEvent armorUnEquipEvent) {
                return armorUnEquipEvent.getUnequippedItem();
            }
        },0);
        EventValues.registerEventValue(DisArmourEvent.class, ItemStack.class, new Getter<ItemStack, DisArmourEvent>() {
            @Override
            public ItemStack get(DisArmourEvent disArmourEvent) {
                return disArmourEvent.getItemStack();
            }
        },0);
        EventValues.registerEventValue(DisArmourEvent.class, Player.class, new Getter<Player, DisArmourEvent>() {
            @Override
            public Player get(DisArmourEvent disArmourEvent) {
                return disArmourEvent.getPlayer();
            }
        },0);
        Skript.registerEffect(EffDisarmor.class,"disarmor %player% [%-string%]");
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }

}
