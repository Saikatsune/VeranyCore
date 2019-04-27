package net.saikatsune.veranycore.bungeecord.commands.staff;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {

    private String message = "";

    public StaffChatCommand() {
        super("staffchat", "", "sc", "staffc", "mc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length > 0) {
                if(player.hasPermission("verany.trial") || player.hasPermission("verany.staff") || player.hasPermission("verany.*")) {
                    for (int i = 0; i < args.length; i++) {
                        message = message + " " + args[i];
                    }
                    for (ProxiedPlayer allPlayers : BungeeCord.getInstance().getPlayers()) {
                        if(allPlayers.hasPermission("verany.trial") || allPlayers.hasPermission("verany.staff") || allPlayers.hasPermission("verany.*")) {
                            allPlayers.sendMessage("§8(§aStaff-Chat§8) §a" + player.getName() + ":§f" + message);
                        }
                    }
                    message = "";
                }
            } else {
                player.sendMessage("§cUsage: /staffchat (msg)");
            }
        }
    }
}
