package structures;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CustomCookie extends ItemStack {

    public CustomCookie() {
        this.setAmount(1);
        this.initializeMeta();
    }

    public CustomCookie(int _amount) {
        this.setAmount(_amount);
        this.initializeMeta();
    }

    private void initializeMeta() {
        this.setType(Material.COOKIE);
        ItemMeta im= this.getItemMeta();
        assert im != null;
        im.setDisplayName("§rCotton candy !");
        im.setLore(List.of("§rRuby's lost cotton candy"));
        this.setItemMeta(im);

    }
}
