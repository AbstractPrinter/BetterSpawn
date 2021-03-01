package cn.wangyudi.betterspawn.mode;

import cn.wangyudi.betterspawn.conf.PointDataConf;
import cn.wangyudi.betterspawn.utils.ExecuteBukkitCommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author AbstractPrinter
 */
public class WeightMode implements SpawnMode {
    private final Player player;
    private List<String> commands;
    private Location spawnLoc;

    public WeightMode(Player player) {
        this.player = player;
        int min = 999999999;
        for (String key : PointDataConf.getConfig().getKeys(false)) {
            Location location = (Location) PointDataConf.getConfig().get(key + "mode");
            if (player.getWorld().equals(location.getWorld())) {
                int weight = PointDataConf.getConfig().getInt(key + "weight");
                if (weight > min) {
                    min = weight;
                    spawnLoc = location;
                    this.commands = PointDataConf.getConfig().getStringList(key + "commands");
                }
            }
        }
    }

    @Override
    public Location getSpawnLocation() {
        ExecuteBukkitCommand.executeCommands(player, commands);
        return spawnLoc;
    }
}
