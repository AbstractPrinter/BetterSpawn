package cn.wangyudi.betterspawn;

import cn.wangyudi.betterspawn.bstats.Metrics;
import cn.wangyudi.betterspawn.command.MainCommand;
import cn.wangyudi.betterspawn.conf.MainConf;
import cn.wangyudi.betterspawn.conf.PointDataConf;
import cn.wangyudi.betterspawn.conf.WorldModeConf;
import cn.wangyudi.betterspawn.listener.PlayerRespawnListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author AbstractPrinter
 * @date 2021/02/27
 */
public final class BetterSpawn extends JavaPlugin {
    private static BetterSpawn instance;

    public static BetterSpawn getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveAllConfig();
        regAllListener();
        regAllCommand();
        collectInf();
    }

    @Override
    public void onDisable() {
        getLogger().info("关闭时再保存一次数据，防止异常关机时数据没有保存。");
        MainConf.saveConfig();
        PointDataConf.saveConfig();
    }

    private void saveAllConfig() {
        saveResource("MainConfig.yml", false);
        saveResource("PointData.yml", false);
        saveResource("WorldMode.yml",false);
    }

    private void regAllListener() {
        getLogger().info("注册监听器");
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
    }

    private void regAllCommand() {
        getLogger().info("注册命令");
        getServer().getPluginCommand("betterspawn").setExecutor(new MainCommand());
    }

    private void collectInf() {
        if (MainConf.getConfig().getBoolean("Bstats.Enabled")) {
            getLogger().info("bStats 开始工作。");
            new Metrics(this, 10498);
        }
    }
}
