package Events;


import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {

    @EventHandler
    public void damagedByCreeper(EntityDamageByEntityEvent e) {

        if(e.getDamager().getType().equals(EntityType.CREEPER)) {
            if (e.getEntity() instanceof Player || e.getEntity() instanceof Animals || e.getEntity() instanceof Item || e.getEntity() instanceof Monster) e.setCancelled(true);
        }

    }
}
