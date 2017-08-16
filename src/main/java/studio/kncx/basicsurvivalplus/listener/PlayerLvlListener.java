package studio.kncx.basicsurvivalplus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerLvlListener implements Listener {

    public final double defaultHeal = 20;
    @EventHandler
    public void onPlayerLvlChanged(PlayerLevelChangeEvent event){
        Player player = event.getPlayer();
        if (player.getLevel() >= 60){
            return;
        }
        //增加血槽
        double healAdded = event.getNewLevel();
        player.setMaxHealth(20 + healAdded);

    }

}
