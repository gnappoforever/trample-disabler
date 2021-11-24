package org.duckdns.davbosca;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.duckdns.davbosca.listener.FarmlandHandlers;

public class TrampleDisabler extends JavaPlugin {
    // This code is called after the server starts and after the /reload command
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new FarmlandHandlers(), this);
        getLogger().log(Level.INFO, "{0}.onEnable()", this.getClass().getName());
    }

    // This code is called before the server stops and after the /reload command
    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "{0}.onDisable()", this.getClass().getName());
    }
}
