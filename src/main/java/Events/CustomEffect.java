package Events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class CustomEffect implements Listener {

    private Map<String, Integer> milkDrinkers = new HashMap<>();
    @EventHandler
    public void MilkEvent(PlayerItemConsumeEvent e) {

        Player p = e.getPlayer();
        String name = p.getName();

        if( e.getItem().getType().equals(Material.MILK_BUCKET)) {

            if(!this.milkDrinkers.containsKey(name)) {
                this.milkDrinkers.put(name,1);
            }
            this.milkDrinkers.put(name, milkDrinkers.get(name) + 1);

            if(this.milkDrinkers.get(name) == 5)
            {
                Bukkit.broadcastMessage(name + " loves milk");
                this.milkDrinkers.put(name, 0);
            }
        }

    }
}
