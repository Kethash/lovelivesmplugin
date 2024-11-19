package Events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomEffect implements Listener {

    private final int pickupCooldown = 60;

    private Map<Entity, Long> entityPickupCooldown = new HashMap<>();

    private final Map<Material, String> specialItemPickups = new HashMap<>(){{
        put(Material.DIAMOND, "Takusan no kibou to kirameki noseta uta o utaou\nKono daiamondo\n" +
                "Kono daiamondo hikatte... :cry:");
        put(Material.EMERALD, "PIKEYYY!");
    }};

    private final List<Biome> umiBiomes = new ArrayList<>(){{
        add(Biome.OCEAN);
        add(Biome.COLD_OCEAN);
        add(Biome.DEEP_COLD_OCEAN);
        add(Biome.DEEP_FROZEN_OCEAN);
        add(Biome.DEEP_OCEAN);
        add(Biome.LUKEWARM_OCEAN);
        add(Biome.WARM_OCEAN);
        add(Biome.FROZEN_OCEAN);
    }};

    private final List<Biome> evergreenBiomes = new ArrayList<>() {{
       add(Biome.TAIGA);
       add(Biome.OLD_GROWTH_PINE_TAIGA);
       add(Biome.SNOWY_TAIGA);
       add(Biome.OLD_GROWTH_SPRUCE_TAIGA);
    }};

    private List<Player> umiBiomesPlayers = new ArrayList<>();
    private List<Player> evergreenPlayers = new ArrayList<>();

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

    @EventHandler
    public void UmiKimochi(PlayerMoveEvent pme) {

        Player p = pme.getPlayer();
        Biome loc = p.getLocation().getBlock().getBiome();

        if(this.umiBiomes.contains(loc) && !this.umiBiomesPlayers.contains(p)){
            Bukkit.broadcastMessage(String.format("<%s> 海を見ているといい気分になる。", p.getName()));
            this.umiBiomesPlayers.add(p);
        } else if (this.evergreenBiomes.contains(loc) && !this.evergreenPlayers.contains(p)) {
            Bukkit.broadcastMessage(String.format("<%s> Dokomademo hirogatte iru evaaguriin to sora", p.getName()));
            this.evergreenPlayers.add(p);
        }
    }

    @EventHandler
    public void itemGet(EntityPickupItemEvent epie) {

        Material item = epie.getItem().getItemStack().getType();
        Entity e = epie.getEntity();

        if(!specialItemPickups.containsKey(item))
            return;

        if(!entityPickupCooldown.containsKey(e) || System.currentTimeMillis() > entityPickupCooldown.get(e)) {
            Bukkit.broadcastMessage(String.format("<%s> %s",e.getName(),specialItemPickups.get(item)));
            this.entityPickupCooldown.put(e, System.currentTimeMillis() + this.pickupCooldown*1000);
        }

    }
}
