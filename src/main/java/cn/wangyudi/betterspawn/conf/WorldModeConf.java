package cn.wangyudi.betterspawn.conf;

import cn.wangyudi.betterspawn.BetterSpawn;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author AbstractPrinter
 * @date 2021/02/27
 */
public class WorldModeConf {
    private static YamlConfiguration config;
    private static String configFile;

    public static void reload() {
        configFile = BetterSpawn.getInstance().getDataFolder() + File.separator + "WorldMode.yml";
        config = YamlConfiguration.loadConfiguration(new File(configFile));
    }

    public static YamlConfiguration getConfig() {
        if (config == null) {
            reload();
        }
        return config;
    }

    public static void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
