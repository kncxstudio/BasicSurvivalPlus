package studio.kncx.basicsurvivalplus.manager;

import me.winterguardian.easyscoreboards.ScoreboardUtil;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHelper {

    public static void updatePlayerScoreboard(Player player){
//        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
//        Objective o = scoreboard.registerNewObjective("status","");
//        o.setDisplaySlot(DisplaySlot.SIDEBAR);
//        o.setDisplayName(ChatColor.GREEN + "状态");
//
//        //血量显示
//        Score healthScore = o.getScore(ChatColor.RED + "血量:");
//        healthScore.setScore((int) (player.getHealth() + 0.5));
//
//        //升级所需经验显示
//        Score expToLevelScore = o.getScore(ChatColor.GREEN + "升级所需经验:");
//        expToLevelScore.setScore((int) (player.getExpToLevel() - player.getExp()));
//
//
//        //用户到服务器ping值
//        Score pingScore = o.getScore(ChatColor.AQUA + "延迟(ms)：");
//        pingScore.setScore(((CraftPlayer)player).getHandle().ping);
//
//
//        player.setScoreboard(scoreboard);
        String[] scoresLayout = new String[6];
        scoresLayout[0] = ChatColor.GREEN + "状态";
        scoresLayout[1] = "";
        scoresLayout[2] = ChatColor.RED + "血量: " + (int) (player.getHealth() + 0.5);
        scoresLayout[3] = ChatColor.GREEN + "升级所需经验: " + (int) (player.getExpToLevel() - player.getExp());
        scoresLayout[4] = ChatColor.AQUA + "延迟: " + ((CraftPlayer)player).getHandle().ping + "ms";
        scoresLayout[5] = "";
        ScoreboardUtil.unrankedSidebarDisplay(player,scoresLayout);
    }

}
