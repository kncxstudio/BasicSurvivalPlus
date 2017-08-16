package studio.kncx.basicsurvivalplus.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onPlayerGotDamage(EntityDamageByEntityEvent event){
        Entity dagager = event.getDamager();
        Entity wounded = event.getEntity();
        int damage = (int)(event.getDamage() + 0.5);

        if (wounded instanceof Player){
            ((Player)wounded).sendMessage("§d[伤害] §b"+ dagager.getName() + "§e对你造成 §b" + damage +" §e点伤害");
        }

        if (dagager instanceof Player){
            ((Player)dagager).sendMessage("§d[伤害]" + "§e你对 §b"+wounded.getName()+ "§e造成 §b" + damage +" §e点伤害");

        }

    }
}
