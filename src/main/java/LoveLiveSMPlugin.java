import Commands.CommandUtilities;
import Events.ChatEvent;
import Events.CustomEffect;
import Events.MainEvents;
import Events.PlayerDeath;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public class LoveLiveSMPlugin extends JavaPlugin {
    @Override
    public void onEnable() {

        Map<String, CommandExecutor> commands = new HashMap<>() {{
            put("informations", new CommandUtilities());
            put("alert", new CommandUtilities());
        }};

        Listener[] events = new Listener[] {new MainEvents(), new PlayerDeath(), new CustomEffect(), new ChatEvent()};

        for (Listener event : events) {
            getServer().getPluginManager().registerEvents(event, this);
        }

        for (Map.Entry<String, CommandExecutor> entry : commands.entrySet()) {
            this.getCommand(entry.getKey()).setExecutor(entry.getValue());
        }

    }
    @Override
    public void onDisable() {
        getLogger().info("Raburaibu plugin is disabled !");
    }
}
