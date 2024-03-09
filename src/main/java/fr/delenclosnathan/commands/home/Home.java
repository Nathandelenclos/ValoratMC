package fr.delenclosnathan.commands.home;

import fr.delenclosnathan.managers.ConfigManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    private final ConfigManager configManager;

    public Home(ConfigManager configManager) {
        this.configManager = configManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (!command.getName().equalsIgnoreCase("home") && args.length > 1) return false;

        Player player = (Player) sender;

        FileConfiguration config = configManager.getConfig("homes.yml");
        Location location = (Location) config.get(player.getName() + "_" + args[0]);
        if (location == null) {
            player.sendMessage("Home " + args[0] + " not found!");
            return false;
        }
        player.teleport(location);
        player.sendMessage("Teleported to home " + args[0] + "!");
        return true;
    }
}
