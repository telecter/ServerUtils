package dev.telecter.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class TimerCommand implements CommandExecutor {
    private BukkitTask task;
    private int times = 10;
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("ServerUtils");
        if (args.length < 1) {
            return false;
        }
        times = Integer.parseInt(args[0]);
        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (times < 1) {
                    task.cancel();
                }
                Bukkit.getOnlinePlayers().forEach(player -> {
                    ChatColor color = ChatColor.GREEN;
                    if (times < 3) {
                        color = ChatColor.RED;
                    }
                    else if (times < 6) {
                        color = ChatColor.YELLOW;
                    }
                    player.sendTitle(color + String.valueOf(times), null);
                });
                times--;
            }
        }.runTaskTimer(plugin, 0, 20);

        return true;
    }
}