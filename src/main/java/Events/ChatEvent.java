package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    @EventHandler
    public void KasuKasu(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();
        String text = e.getMessage();

        if(text.toLowerCase().contains("kasukasu")) {
            e.setMessage(text.replace("kasukasu", "L-O-V-E KASUMI !"));
        }

    }
}
