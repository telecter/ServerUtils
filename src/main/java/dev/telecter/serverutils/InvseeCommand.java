package dev.telecter.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player p) {
            if (args.length < 1) {
                p.sendMessage(ChatColor.RED + "You must provide a player");
                return false;
            }
            String playerName = args[0];
            Player target = Bukkit.getPlayer(playerName);
            if (target == null) {
                p.sendMessage(ChatColor.RED + "No player was found");
            }
            p.openInventory(target.getInventory());
            return true;
        }
        return false;
    }
}