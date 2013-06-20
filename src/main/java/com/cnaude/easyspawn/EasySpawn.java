package com.cnaude.easyspawn;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Chris Naudé
 */
public class EasySpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("setspawn").setExecutor(this);
        getServer().getPluginManager().registerEvents(new RespawnHandler(), this);
    }

    @Override
    public void onDisable() {
        getCommand("setspawn").setExecutor(null);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("easyspawn.set")) {
                Location l = p.getLocation();
                int x = l.getBlockX();
                int y = l.getBlockY();
                int z = l.getBlockZ();
                p.sendMessage(ChatColor.GOLD + "Spawn is now set to "
                        + "X="+ x + ", Y=" + y + ", Z=" + z);
                p.getWorld().setSpawnLocation(x, y, z);
                return true;
            }
        }
        return true;
    }
}
