package structures;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class DeathByPlayer {
    private static DeathByPlayer instance;

    private DeathByPlayer() {
    }

    public static DeathByPlayer getInstance() {
        if (instance == null) {
            instance = new DeathByPlayer();
        }
        return instance;
    }

    public static String check(Player dead, EntityDamageEvent ede, EntityDamageEvent.DamageCause dc) {

        return dead.getName() + " was slain by " + ((Player) ede).getDisplayName() + " with " + dc;
    }


}
