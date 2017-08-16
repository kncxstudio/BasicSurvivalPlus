package studio.kncx.basicsurvivalplus;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import studio.kncx.basicsurvivalplus.listener.PlayerDamageListener;
import studio.kncx.basicsurvivalplus.listener.PlayerLifercycleListener;
import studio.kncx.basicsurvivalplus.listener.PlayerLvlListener;
import studio.kncx.basicsurvivalplus.listener.PreventExplosionListner;
import studio.kncx.basicsurvivalplus.manager.CommandManager;
import studio.kncx.basicsurvivalplus.manager.ScoreboardHelper;

public class Main extends JavaPlugin {
    private Server server = null;
    private PluginManager pluginManager = null;

    private void init(){
        server = getServer();
        pluginManager = server.getPluginManager();
        CommandManager.init(this);
    }



    @Override
    public void onEnable() {
        super.onEnable();
        init();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        server.getLogger().info(ChatColor.GREEN + "[BasicSurvivalPlus]插件加载成功!");
        pluginManager.registerEvents(new PlayerLvlListener(),this);
        pluginManager.registerEvents(new PlayerLifercycleListener(this),this);
        pluginManager.registerEvents(new PlayerDamageListener(),this);
        pluginManager.registerEvents(new PreventExplosionListner(this),this);

    }



    @Override
    public void onDisable() {
        super.onDisable();
        server.getLogger().info(ChatColor.GREEN + "BasicSurvivalPlus插件停用成功!");
        server.savePlayers();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      return CommandManager.onCommand(sender,command,label,args);
    }
}
