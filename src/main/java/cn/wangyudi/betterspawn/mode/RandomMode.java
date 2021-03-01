package cn.wangyudi.betterspawn.mode;

import org.bukkit.Location;
import org.bukkit.entity.Player;


/**
 * @author AbstractPrinter
 */
public class RandomMode implements SpawnMode {
    Player player;

    public RandomMode(Player player) {
        this.player = player;
    }

    @Override
    public Location getSpawnLocation() {
        return null;
    }
}
