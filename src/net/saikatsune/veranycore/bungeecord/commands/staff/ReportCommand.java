package net.saikatsune.veranycore.bungeecord.commands.staff;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class ReportCommand extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    private String message = "";

    public ReportCommand() {
        super("report");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length >= 2) {
                ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
                if(target != null) {
                    if(target != player) {
                        for (int i = 1; i < args.length; i++) {
                            message = message + " " + args[i];
                        }
                        for (ProxiedPlayer allPlayers : BungeeCord.getInstance().getPlayers()) {
                            if(allPlayers.hasPermission("verany.trial") || allPlayers.hasPermission("verany.staff") || allPlayers.hasPermission("verany.*")) {
                                allPlayers.sendMessage("§8(§4Reports§8) §c" + player.getName() + " §ehas reported §c" + target.getName() + " §efor§c" + message + "§e!");
                            }
                        }
                        player.sendMessage(veranyCore.getPrefix() + "§aYour report has been sent to our moderators!");
                        message = "";
                    } else {
                        player.sendMessage(veranyCore.getPrefix() + "§cYou cannot report yourself!");
                    }
                } else {
                    player.sendMessage(veranyCore.getPrefix() + "§c" + args[0] + " is currently offline!");
                }
            } else if(args.length < 2) {
                player.sendMessage("§cUsage: /report (ign) (reason)");
            }
        }
    }
}
