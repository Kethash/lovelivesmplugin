package structures;

import exceptions.CauseNotFoundException;
import exceptions.NameNotFoundException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.HashMap;
import java.util.Map;

import utility.Functions;


public class DeathByOther {
    private DeathByOther instance;
    private static Map<DamageCause, String> othercauses = new HashMap<>() {{
        put(DamageCause.SUFFOCATION, "died by suffocation ! Oof");
        put(DamageCause.FALL, "believed he could fly !");
    }};

    private static Map<String, String> customNameCause = new HashMap<>() {{
        put("kanata", " was forced to take a nap with Kanata");
    }};

    private DeathByOther() {}

    public static String check(DamageCause dc) throws CauseNotFoundException {

        return " " + Functions.checkDamageCauses(othercauses, dc);
    }

    public static String checkCustomName(EntityDamageEvent ede) throws NameNotFoundException {
        return " " + Functions.checkCustomNames(customNameCause, ((Entity) ede).getCustomName());
    }


}
