package dev.telecter.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    private void heal(Player target) {
        target.setHealth(20);
        target.setSaturation(20);
        target.setFoodLevel(20);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target = null;
        if (args.length > 0) {
            target = Bukkit.getPlayer(args[0]);
        }
        else {
            if (sender instanceof Player) {
                target = ((Player) sender);
            }
        }
        if (target != null) {
            heal(target);
            sender.sendMessage("Healed " + target.getName());
            return true;
        }
        return false;
    }
}
