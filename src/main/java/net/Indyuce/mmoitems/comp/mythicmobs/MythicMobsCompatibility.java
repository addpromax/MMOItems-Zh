package net.Indyuce.mmoitems.comp.mythicmobs;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicReloadedEvent;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.comp.mythicmobs.stat.FactionDamage;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.*;

public class MythicMobsCompatibility implements Listener {

    public MythicMobsCompatibility() {

        // Gonna keep the try catch here for a safety net.
        try {
            for (String faction : this.getFactions())
                MMOItems.plugin.getStats().register(new FactionDamage(faction));
        } catch (NullPointerException ignored) {
        }

        Bukkit.getPluginManager().registerEvents(this, MMOItems.plugin);
    }

    /**
     * MythicLib skill handlers are reloaded on priority {@link EventPriority#NORMAL}
     * MMOCore and MMOItems use HIGH or HIGHEST
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void a(MythicReloadedEvent event) {

        // Update skills
        MMOItems.plugin.getSkills().initialize(true);
    }

    private Set<String> getFactions() {
        Set<String> allFactions = new HashSet<>();

        // Collects all mythic mobs + edited vanilla mobs in mythic mobs.
        List<MythicMob> mobs = new ArrayList<>(MythicMobs.inst().getMobManager().getVanillaTypes());
        mobs.addAll(MythicMobs.inst().getMobManager().getMobTypes());
        // Adds their faction to the set if it is set.

        for (MythicMob mob : mobs)
            // Checks if it has a faction.
            if (mob.hasFaction())
                allFactions.add(mob.getFaction());

        return allFactions;
    }
}