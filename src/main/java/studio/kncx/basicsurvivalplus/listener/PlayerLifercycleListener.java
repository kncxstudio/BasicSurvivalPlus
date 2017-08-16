package studio.kncx.basicsurvivalplus.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import studio.kncx.basicsurvivalplus.manager.ScoreboardHelper;

public class PlayerLifercycleListener implements Listener {

    JavaPlugin plugin = null;
    public PlayerLifercycleListener(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        ScoreboardHelper.updatePlayerScoreboard(event.getPlayer());
    }

    @EventHandler
    public void onPlayerGainExp(PlayerExpChangeEvent event){
        Player player = event.getPlayer();
        Server server = player.getServer();
        int expNum = event.getAmount();
        if (expNum > 0){
            expNum = (int) (expNum * plugin.getConfig().getInt("EXP_RATE"));

            player.sendMessage("§d[状态]§e获得 §b"+expNum+" §e点经验!");
            event.setAmount(expNum);
        }
    }

    @EventHandler
    public void onPlayerBeenKilled(PlayerDeathEvent event){
        event.setDroppedExp(0);
    }

    @EventHandler
    public void onPlayerReborn(PlayerRespawnEvent event){
        event.getPlayer().setExp(0);
        event.getPlayer().setLevel(0);
    }
}
