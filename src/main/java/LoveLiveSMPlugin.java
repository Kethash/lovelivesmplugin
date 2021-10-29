import Events.ChatEvent;
import Events.CustomEffect;
import Events.MainEvents;
import Events.PlayerDeath;
import org.bukkit.plugin.java.JavaPlugin;

public class LoveLiveSMPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MainEvents(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new CustomEffect(), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
