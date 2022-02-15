package com.ArmorSk.Skript.Events;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import org.bukkit.event.Event;
import org.checkerframework.checker.nullness.qual.NonNull;

public class EvtDisArmor extends SkriptEvent {
    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        return true;
    }

    @Override
    public String toString(@NonNull Event event, boolean b) {
        return "DisArmorEvent";
    }
}
