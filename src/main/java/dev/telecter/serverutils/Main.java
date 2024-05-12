package dev.telecter.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Your dumb plugin is working!");
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        Bukkit.getPluginCommand("invsee").setExecutor(new InvseeCommand());
        Bukkit.getPluginCommand("clientweather").setExecutor(new ClientWeatherCommand());
        Bukkit.getPluginCommand("gui").setExecutor(new GuiCommand());
        Bukkit.getPluginCommand("timer").setExecutor(new TimerCommand());
        Bukkit.getPluginCommand("locateplayer").setExecutor(new LocatePlayerCommand());
    }
}