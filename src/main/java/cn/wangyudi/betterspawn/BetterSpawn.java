package cn.wangyudi.betterspawn;

import cn.wangyudi.betterspawn.bstats.Metrics;
import cn.wangyudi.betterspawn.command.MainCommand;
import cn.wangyudi.betterspawn.conf.MainConf;
import cn.wangyudi.betterspawn.listener.PlayerRespawnListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author AbstractPrinter
 * @date 2021/02/27
 */
public final class BetterSpawn extends JavaPlugin {
    private static BetterSpawn instance;
    private static boolean hasPapi;

    public static BetterSpawn getInstance() {
        return instance;
    }

    public static boolean isHasPapi() {
        return hasPapi;
    }

    @Override
    public void onEnable() {
        instance = this;
        checkLibs();
        saveAllConfig();
        regAllListener();
        regAllCommand();
        collectInf();
        startTasks();
    }

    @Override
    public void onDisable() {
    }

    private void checkLibs() {
        getLogger().info("=== 检测前置插件 ===");
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().info("检测到 PlaceholderAPI");
            hasPapi = true;
        } else {
            getLogger().info("未检测到 PlaceholderAPI");
        }
        if (getServer().getPluginManager().isPluginEnabled("Residence")) {
            getLogger().info("检测到 Residence");
        } else {
            getLogger().info("未检测到 PlaceholderAPI");
        }
    }

    private void saveAllConfig() {
        getLogger().info("=== 配置文件 ===");
        saveResource("MainConfig.yml", false);
        saveResource("PointData.yml", false);
        saveResource("WorldMode.yml", false);
    }

    private void regAllListener() {
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
    }

    private void regAllCommand() {
        getServer().getPluginCommand("betterspawn").setExecutor(new MainCommand());
    }

    private void collectInf() {
        getLogger().info("=== bStats ===");
        if (MainConf.getConfig().getBoolean("Bstats.Enabled")) {
            getLogger().info("bStats 开始工作。");
            new Metrics(this, 10498);
        }
    }

    private void startTasks() {
        //new GenerateRtpPointsTask();
    }
}
