package utility;

import exceptions.CauseNotFoundException;
import exceptions.NameNotFoundException;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.Map;

public class Functions {

    public static String checkDamageCauses(Map<DamageCause, String> causes, DamageCause dc) throws CauseNotFoundException {
        if(!causes.containsKey(dc))
            throw new CauseNotFoundException();

        return causes.get(dc);
    }

    public static String checkCustomNames(Map<String, String> names, String customname) throws NameNotFoundException {
        if(!names.containsKey(customname))
            throw new NameNotFoundException();

        return names.get(customname);
    }
}
