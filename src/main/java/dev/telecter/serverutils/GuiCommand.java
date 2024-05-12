package dev.telecter.serverutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

import java.util.ArrayList;
import java.util.List;

public class GuiCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length < 1) {
                return false;
            }
            InventoryType invType;
            try {
                 invType = InventoryType.valueOf(args[0].toUpperCase());
                p.openInventory(Bukkit.createInventory(null, invType));
            }
            catch (Exception err) {
                p.sendMessage(ChatColor.RED + "Invalid type of inventory");
                return false;
            }
            return true;
        }
        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> list = new ArrayList<>();
        for (InventoryType type : InventoryType.values()) {
            list.add(type.name().toLowerCase());
        }
        return list;
    }
}
