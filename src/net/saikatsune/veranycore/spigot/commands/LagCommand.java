package net.saikatsune.veranycore.spigot.commands;

import net.saikatsune.veranycore.spigot.data.VeranyCore;
import net.saikatsune.veranycore.spigot.tasks.UptimeTask;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LagCommand implements CommandExecutor {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    private UptimeTask uptimeTask = veranyCore.getUptimeTask();

    private Runtime runtime = Runtime.getRuntime();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("lag")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("§7§m-------------------");
                player.sendMessage("§aServer: §f" + Bukkit.getServerName());
                player.sendMessage("§aUptime: §f" + uptimeTask.getFormattedTime());
                player.sendMessage("§aMemory: §f" + ((runtime.totalMemory() - runtime.freeMemory()) / 1048576) + "MiB/" + (runtime.totalMemory() / 1048576) + "MiB");
                player.sendMessage("§7§m-------------------");
            }
        }
        return false;
    }
}
