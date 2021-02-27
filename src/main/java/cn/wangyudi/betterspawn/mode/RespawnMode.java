package cn.wangyudi.betterspawn.mode;

import org.bukkit.Location;

/**
 * @author AbstractPrinter
 */
public interface RespawnMode {
    /**
     * 返回一个重生点
     *
     * @return Location
     */
    Location getRespawnLocation();
}
