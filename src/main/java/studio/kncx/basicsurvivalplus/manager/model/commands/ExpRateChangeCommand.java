package studio.kncx.basicsurvivalplus.manager.model.commands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import studio.kncx.basicsurvivalplus.manager.CommandManager;

public class ExpRateChangeCommand implements BaseCommand {

    public static final String COMMAND = "ExpRate";

    public String getCommandType() {
        return ExpRateChangeCommand.COMMAND.toLowerCase();
    }

    public boolean onCommand(CommandSender sender, String label, String[] args) {
        JavaPlugin plugin = CommandManager.plugin;
        Server server = plugin.getServer();

        if (args.length > 0) {
            if (!sender.hasPermission("exprate.change")) {
                sender.sendMessage("仅管理员可改变当前服务器经验倍率");
                return true;
            }
            plugin.getConfig().set("EXP_RATE", Integer.valueOf(args[0]));
            server.broadcastMessage(ChatColor.BLUE + "服务器经验倍率调整为" + ChatColor.GREEN + plugin.getConfig().getInt("EXP_RATE"));
            plugin.saveConfig();
        } else {
            sender.sendMessage(ChatColor.BLUE + "当前服务器经验倍率为" + ChatColor.GREEN + plugin.getConfig().getInt("EXP_RATE"));
        }
        return true;
    }
}
