package studio.kncx.basicsurvivalplus.manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import studio.kncx.basicsurvivalplus.manager.model.commands.ExpRateChangeCommand;

public class CommandManager {

    public static JavaPlugin plugin = null;


    public static void init(JavaPlugin plugin){
        CommandManager.plugin = plugin;
    }


    public static boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(plugin == null) sender.getServer().getLogger().info("CommandManager Not Init !");

        if (command.getName().equalsIgnoreCase(ExpRateChangeCommand.COMMAND)){
            return new ExpRateChangeCommand().onCommand(sender,label,args);
        }else {
            sender.sendMessage(ChatColor.RED + "Unknown Command");
            return true;
        }
    }

}
