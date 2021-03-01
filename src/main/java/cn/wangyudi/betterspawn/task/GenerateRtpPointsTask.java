package cn.wangyudi.betterspawn.task;

import cn.wangyudi.betterspawn.BetterSpawn;
import cn.wangyudi.betterspawn.conf.MainConf;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

/**
 * @author AbstractPrinter
 */
public class GenerateRtpPointsTask extends BukkitRunnable {
    private final HashMap<World, List<Location>> rtpPointMap = new HashMap<>();

    public GenerateRtpPointsTask() {
        this.runTaskTimer(BetterSpawn.getInstance(), 0, MainConf.getConfig().getLong("Rtp.Interval"));
    }

    @Override
    public void run() {
    }

    public List<Location> getRtpPoints(World world) {
        return new ArrayList<>(rtpPointMap.get(world));
    }
}
