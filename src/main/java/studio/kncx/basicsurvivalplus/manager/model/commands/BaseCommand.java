package studio.kncx.basicsurvivalplus.manager.model.commands;

import org.bukkit.command.CommandSender;

public interface BaseCommand {
    String getCommandType();
    boolean onCommand(CommandSender sender, String label, String[] args);
}
