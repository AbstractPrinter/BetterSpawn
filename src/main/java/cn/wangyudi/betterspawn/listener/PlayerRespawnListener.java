package cn.wangyudi.betterspawn.listener;

import cn.wangyudi.betterspawn.conf.WorldModeConf;
import cn.wangyudi.betterspawn.mode.SpawnModeFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * @author AbstractPrinter
 */
public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        try {
            String worldRespawnMode = WorldModeConf.getConfig().getString(
                    event.getPlayer().getWorld().getName() + ".mode").toLowerCase();
            event.setRespawnLocation(SpawnModeFactory.getSpawnLocation(
                    worldRespawnMode, event.getPlayer()));
        } catch (NullPointerException e) {
            event.setRespawnLocation(event.getPlayer().getWorld().getSpawnLocation());
        }
    }
}
