package net.saikatsune.veranycore.bungeecord.commands.messages;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class MessageCommand extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    private String message = "";

    public MessageCommand() {
        super("message", "", "msg", "pm", "m");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length >= 2) {
                ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
                if(target != null) {
                    if(target != player) {
                       if(veranyCore.getReceiveMessageHash().get(target).equals(true)) {
                           for (int i = 1; i < args.length; i++) {
                               message = message + " " + args[i];
                           }
                           player.sendMessage(veranyCore.getPrefix() + "§aYou §7> §a" + target.getName() + ":§f" + message);
                           target.sendMessage(veranyCore.getPrefix() + "§a" + target.getName() + " §7> §aYou:§f" + message);

                           veranyCore.getReplyHash().put(player, target);
                           veranyCore.getReplyHash().put(target, player);

                           message = "";
                       } else {
                           player.sendMessage(veranyCore.getPrefix() + "§c" + target.getName() + " doesn't want to receive messages!");
                       }
                    } else {
                        player.sendMessage(veranyCore.getPrefix() + "§cYou cannot message yourself!");
                    }
                } else {
                    player.sendMessage(veranyCore.getPrefix() + "§c" + args[0] + " is currently offline!");
                }
            } else if(args.length < 2) {
                player.sendMessage("§cUsage: /message (ign) (msg)");
            }
        }
    }
}
