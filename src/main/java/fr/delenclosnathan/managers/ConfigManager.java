package fr.delenclosnathan.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final JavaPlugin plugin;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
    }

    public FileConfiguration getConfig(String name) {
        File file = new File(plugin.getDataFolder(), name);
        return org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
    }

    public void saveConfig(FileConfiguration config, String name) {
        File file = new File(plugin.getDataFolder(), name);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
