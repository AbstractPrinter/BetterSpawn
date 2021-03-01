package cn.wangyudi.betterspawn.utils;

import cn.wangyudi.betterspawn.BetterSpawn;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author AbstractPrinter
 */
public class ExecuteBukkitCommand {
    public static void executeCommands(Player player, List<String> commands) {
        for (String command : commands) {
            executeCommand(player, command);
        }
    }

    public static void executeCommand(Player player, String command) {
        if (command.split("\\|").length != 2) {
            throw new RuntimeException("配置文件中command格式有问题！");
        }
        String exeCuter = command.split("\\|")[0].toLowerCase();
        if (BetterSpawn.isHasPapi()) {
            command = PlaceholderAPI.setPlaceholders(player, command);
        }
        switch (exeCuter) {
            case "player":
                player.performCommand(command);
                break;
            case "op":
                player.setOp(true);
                player.performCommand(command);
                player.setOp(false);
                break;
            case "console":
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                break;
            default:
                throw new RuntimeException("command执行对象错误！");
        }
    }
}
