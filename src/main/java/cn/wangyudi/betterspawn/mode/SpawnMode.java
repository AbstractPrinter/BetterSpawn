package cn.wangyudi.betterspawn.mode;


import org.bukkit.Location;

/**
 * @author AbstractPrinter
 */
public interface SpawnMode {
    /**
     * 获取重生地点
     *
     * @return Location
     */
    Location getSpawnLocation();
}
