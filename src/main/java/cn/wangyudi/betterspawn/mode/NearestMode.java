package cn.wangyudi.betterspawn.mode;

import cn.wangyudi.betterspawn.conf.PointDataConf;
import cn.wangyudi.betterspawn.utils.ExecuteBukkitCommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;


/**
 * @author AbstractPrinter
 */
public class NearestMode implements SpawnMode {
    private final Player player;
    private List<String> commands;
    private Location spawnLoc;

    public NearestMode(Player player) {
        this.player = player;
        double min = 999999999;
        for (String key : PointDataConf.getConfig().getKeys(false)) {
            Location location = (Location) PointDataConf.getConfig().get(key + ".location");
            if (location.getWorld().equals(player.getWorld())) {
                double distance = player.getLocation().distance(location);
                if (distance < min) {
                    min = distance;
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
