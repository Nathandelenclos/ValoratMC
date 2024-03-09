package fr.delenclosnathan.commands.home;

import fr.delenclosnathan.managers.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {

    private ConfigManager configManager;

    public SetHome(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (!command.getName().equalsIgnoreCase("sethome") && args.length > 1) return false;

        Player player = (Player) sender;

        FileConfiguration config = configManager.getConfig("homes.yml");
        config.set(player.getName() + "_" + args[0], player.getLocation());
        configManager.saveConfig(config, "homes.yml");
        player.sendMessage("Home set!", player.getLocation().toString());
        return true;
    }
}
