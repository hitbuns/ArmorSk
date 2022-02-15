package com.ArmorSk.Utilities;

import com.ArmorSk.Events.AddItemToInventoryEvent;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;

public class ItemAdder {

    public static boolean addItem(Player player,ItemStack... itemStacks) {
        if (player == null) return false;

        AddItemToInventoryEvent addItemToInventoryEvent = new AddItemToInventoryEvent(player,itemStacks);
        if (BukkitEventCaller.callEvent(addItemToInventoryEvent)) return false;

        Map<Integer,ItemStack> map = player.getInventory().addItem(addItemToInventoryEvent.build().getItemStackArray());
        if (map.size() >= 1) {
            Location location = player.getEyeLocation();
            World world = location.getWorld();
            map.values().forEach(itemStack -> {
                Item item = world.dropItemNaturally(location,itemStack);
                item.setOwner(player.getUniqueId());
            });

            player.sendMessage(Utils.color("&4Inventory is full, dropping items onto the ground!"));
            return false;
        }
        return true;
    }

    public static boolean addItem(Player player, Collection<ItemStack> itemStacks) {
        return addItem(player,itemStacks.toArray(new ItemStack[0]));
    }

}
