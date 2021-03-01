package cn.wangyudi.betterspawn.mode;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * @author AbstractPrinter
 */
public class SpawnModeFactory {
    public static Location getSpawnLocation(String mode, Player player) {
        mode = mode.toLowerCase();
        switch (mode) {
            case "random":
                return new RandomMode(player).getSpawnLocation();
            case "nearest":
                return new NearestMode(player).getSpawnLocation();
            default:
                return player.getLocation().getWorld().getSpawnLocation();
        }
    }
}
