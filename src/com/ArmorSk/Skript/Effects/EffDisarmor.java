package com.ArmorSk.Skript.Effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.ArmorSk.ArmorHandlers.ArmorType;
import com.ArmorSk.Events.ArmorUnEquipEvent;
import com.ArmorSk.Events.DisArmourEvent;
import com.ArmorSk.Utilities.BukkitEventCaller;
import com.ArmorSk.Utilities.ItemAdder;
import com.ArmorSk.Utilities.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EffDisarmor extends Effect {

    private Expression<Player> player;
    private Expression<String> s;
//    private Expression<ArmorType> armorTypeExpression;
    List<ArmorType> armorTypes = Arrays.stream(ArmorType.values()).collect(Collectors.toList());

    ArmorType random(Player player) {
        List<ArmorType> list = armorTypes.stream().filter(armorType -> player.getInventory().getItem(armorType.getSlot()) != null).collect(Collectors.toList());
        return list.size() > 0 ? list.get(Utils.RNG_INT(0,list.size()-1)) : null;
    }

    @Override
    protected void execute(Event event) {
//        ArmorType armorType = this.armorTypeExpression != null ? armorTypeExpression.getSingle(event) : random();
        Player player1 = player.getSingle(event);
        ArmorType armorType = this.s != null ? ArmorType.valueOf(this.s.getSingle(event).toUpperCase()) : random(player1);

        if (armorType == null) return;

        ItemStack itemStack = player1.getInventory().getItem(armorType.getSlot());
        if (itemStack == null || BukkitEventCaller.callEvent(new DisArmourEvent(player1
                ,armorType,itemStack)) || BukkitEventCaller.callEvent(
                new ArmorUnEquipEvent(player1,itemStack)
        )) {
            return;
        }

        ItemAdder.addItem(player1,itemStack);
        player1.getInventory().setItem(armorType.getSlot(),null);
    }

    @Override
    public String toString(@Nonnull Event event, boolean b) {
        return "Disarmored: "+player.toString(event,b)+"||"+s.toString(event,b);
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.s = (Expression<String>) expressions[1];
//        this.armorTypeExpression = (Expression<ArmorType>) expressions[1];
        return true;
    }
}
