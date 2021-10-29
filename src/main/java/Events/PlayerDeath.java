package Events;

import exceptions.CauseNotFoundException;
import exceptions.NameNotFoundException;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import structures.DeathByOther;
import structures.DeathByPlayer;

import java.util.HashMap;
import java.util.Map;

public class PlayerDeath implements Listener {

    private Map<String, String> specialPlayers = new HashMap<>() {{
        put("GuardianRexs", "died because rina is too cute");
        put("Kettash", "tried weird spiritual stuff with Nozomi");
    }};

    @EventHandler
    public void playerdiesEvent(PlayerDeathEvent e)
    {

        World carte = e.getEntity().getWorld();

        for(Player p : carte.getPlayers()) {
            carte.playSound(p.getLocation(), Sound.ENTITY_CAT_DEATH, 1.0f, 1.0f);
        }


        Player dead = e.getEntity();
        String name = dead.getName();
        EntityDamageEvent ede = e.getEntity().getLastDamageCause();
        EntityDamageEvent.DamageCause dc = ede.getCause();


        if(ede instanceof Player)
        {
            // If the entity was killed by a Player
            e.setDeathMessage(DeathByPlayer.check(dead,ede,dc));
        }
        else if (this.specialPlayers.containsKey(name)) {
            e.setDeathMessage(name + " " + specialPlayers.get(name));
        }
        else if (ede instanceof Entity && ((Entity) ede).getCustomName() != null) {
            // Check if the entity has a custom name
            try{
                e.setDeathMessage(name + DeathByOther.checkCustomName(ede));
            } catch (NameNotFoundException ignored) {
            }
        }
        else {
            // Other checking DamageCause stuff
            try {
                e.setDeathMessage(name + DeathByOther.check(dc));
            } catch(CauseNotFoundException ignored) {
            }
        }
    }
}
