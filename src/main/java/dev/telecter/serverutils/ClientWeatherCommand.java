package dev.telecter.serverutils;

import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClientWeatherCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }
        if (sender instanceof Player p) {
            switch (args[0]) {
                case "clear":
                    args[0] = "CLEAR";
                    break;
                case "rain":
                    args[0] = "DOWNFALL";
                    break;
                default:
                    return false;
            }
            p.setPlayerWeather(WeatherType.valueOf(args[0]));
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> list = new ArrayList<>();
        list.add("rain");
        list.add("clear");
        return list;
    }
}
