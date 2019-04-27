package net.saikatsune.veranycore.bungeecord.commands.connection;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class PingCommand extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    public PingCommand() {
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length == 0) {
                player.sendMessage(veranyCore.getPrefix() + "§fYour ping: §a" + player.getPing() + "ms");
            } else if(args.length == 1) {
                ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
                if(target != null) {
                    if(target != player) {
                        player.sendMessage(veranyCore.getPrefix() + "§f" + target.getName() + "'s ping: §a" + target.getPing() + "ms");
                    } else {
                        player.sendMessage(veranyCore.getPrefix() + "§fYour ping: §a" + player.getPing() + "ms");
                    }
                } else {
                    player.sendMessage(veranyCore.getPrefix() + "§c" + args[0] + " is currently offline!");
                }
            }
        }
    }
}
