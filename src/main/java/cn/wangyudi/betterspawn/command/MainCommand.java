package cn.wangyudi.betterspawn.command;

import cn.wangyudi.betterspawn.conf.MainConf;
import cn.wangyudi.betterspawn.conf.PointDataConf;
import cn.wangyudi.betterspawn.conf.WorldModeConf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author AbstractPrinter
 */
public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("BetterSpawn.admin")) {
                this.reload();
                sender.sendMessage("RELOAD OK.");
            }
            return true;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("addPoint")) {
            if (sender.hasPermission("BetterSpawn.admin")) {
                if (sender instanceof Player) {
                    Player player = ((Player) sender).getPlayer();
                    String spawnName = args[1];
                    String[] needs = new String[]{""};
                    String[] commands = new String[]{""};
                    int weight = 0;
                    PointDataConf.getConfig().set(spawnName + ".weight", weight);
                    PointDataConf.getConfig().set(spawnName + ".needs", needs);
                    PointDataConf.getConfig().set(spawnName + ".commands", commands);
                    PointDataConf.getConfig().set(spawnName + ".location", player.getLocation());
                    PointDataConf.saveConfig();
                    sender.sendMessage("ADD OK");
                } else {
                    sender.sendMessage("必须是玩家状态，才能正常使用这个指令。");
                }
            }
            return true;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("delPoint")) {
            if (sender.hasPermission("BetterSpawn.admin")) {
                String spawnName = args[1];
                if (PointDataConf.getConfig().get(spawnName) != null) {
                    PointDataConf.getConfig().set(spawnName, null);
                    PointDataConf.saveConfig();
                    sender.sendMessage("DEL OK");
                } else {
                    sender.sendMessage("DEL ERROR > NOT FOUND POINT");
                }
            }
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            help(sender);
        }
        return false;
    }

    private void help(CommandSender sender) {
        sender.sendMessage("BetterSpawn");
        sender.sendMessage("/bts addPoint <spawnName> 添加一个点");
        sender.sendMessage("/bts delPoint <spawnName> 删除一个点");
        sender.sendMessage("/bts reload 重载");
    }

    private void reload() {
        MainConf.reload();
        PointDataConf.reload();
        WorldModeConf.reload();
    }
}
