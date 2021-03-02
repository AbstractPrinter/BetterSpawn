package cn.wangyudi.betterspawn.task;

import cn.wangyudi.betterspawn.BetterSpawn;
import cn.wangyudi.betterspawn.conf.MainConf;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;

/**
 * @author AbstractPrinter
 */
public class GenerateRtpPointsTask extends BukkitRunnable {
    private boolean first = false;
    private final boolean hasResidence;
    private final int updateInterval;
    private final int pointAmount;
    private final int protectionRadius;

    private HashMap<World, List<Location>> randomPoints;

    public GenerateRtpPointsTask() {
        this.updateInterval = MainConf.getConfig().getInt("Rtp.UpdateInterval");
        this.pointAmount = MainConf.getConfig().getInt("Rtp.PointAmount");
        this.protectionRadius = MainConf.getConfig().getInt("Rtp.ProtectionRadius");
        this.hasResidence = MainConf.getConfig().getBoolean("Rtp.HasResidence");
        this.randomPoints = new HashMap<>();
        this.runTaskTimer(BetterSpawn.getInstance(), 0, updateInterval);
    }

    private Location generateRandomPoint(World world){

        return null;
    }

    @Override
    public void run() {

    }
}
