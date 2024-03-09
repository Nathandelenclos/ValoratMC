package fr.delenclosnathan;

import fr.delenclosnathan.commands.HelloWorld;
import fr.delenclosnathan.commands.home.Home;
import fr.delenclosnathan.commands.home.SetHome;
import fr.delenclosnathan.managers.ConfigManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JavaPlugin {

    private final ConfigManager configManager = new ConfigManager(this);

    Map<String, CommandExecutor> commands = Map.of(
            "helloworld", new HelloWorld(),
            "sethome", new SetHome(configManager),
            "home", new Home(configManager)
    );
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called");
        for (Map.Entry<String, CommandExecutor> entry : commands.entrySet()) {
            Objects.requireNonNull(getCommand(entry.getKey())).setExecutor(entry.getValue());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable is called");
    }
}
