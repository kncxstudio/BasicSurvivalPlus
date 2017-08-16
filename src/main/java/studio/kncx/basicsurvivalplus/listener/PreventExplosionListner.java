package studio.kncx.basicsurvivalplus.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PreventExplosionListner implements Listener{
    private JavaPlugin plugin = null;
    public PreventExplosionListner(JavaPlugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onExplosionEvent(EntityExplodeEvent event){
        if (plugin.getConfig().getBoolean("PREVENT_EXPLOSION")){
            event.setCancelled(true);
        }
    }
}
