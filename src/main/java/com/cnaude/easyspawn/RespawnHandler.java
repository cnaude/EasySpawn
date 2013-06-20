package com.cnaude.easyspawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Handles respawns.
 * @author Starbuck
 */
public class RespawnHandler implements Listener {
    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onRespawn(PlayerRespawnEvent event) {
        if (!event.isBedSpawn()) {
            event.setRespawnLocation(event.getRespawnLocation().getWorld().getSpawnLocation());
        }
    }
    
    @EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
    public void onFirstJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            onRespawn(new PlayerRespawnEvent(event.getPlayer(), event.getPlayer().getLocation(), false));
        }
    }
}
