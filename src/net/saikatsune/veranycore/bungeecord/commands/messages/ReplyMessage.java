package net.saikatsune.veranycore.bungeecord.commands.messages;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class ReplyMessage extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    private String message = "";

    public ReplyMessage() {
        super("reply", "", "r");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length >= 1) {
                ProxiedPlayer target = (ProxiedPlayer) BungeeCord.getInstance().getPlayer(String.valueOf(veranyCore.getReplyHash().get(player)));
                if(veranyCore.getReplyHash().get(player) != null) {
                    if(veranyCore.getReceiveMessageHash().get(target).equals(true)) {
                        if(target != null) {
                            if(target != player) {
                                for (int i = 0; i < args.length; i++) {
                                    message = message + " " + args[i];
                                }
                                player.sendMessage(veranyCore.getPrefix() + "§aYou §7> §a" + target.getName() + ":§f" + message);
                                target.sendMessage(veranyCore.getPrefix() + "§a" + target.getName() + " §7> §aYou:§f" + message);

                                message = "";
                            } else {
                                player.sendMessage(veranyCore.getPrefix() + "§cYou cannot message yourself!");
                            }
                        } else {
                            player.sendMessage(veranyCore.getPrefix() + "§cYou have no one to reply to!");
                        }
                    } else {
                        player.sendMessage(veranyCore.getPrefix() + "§c" + target.getName() + " doesn't want to receive messages!");
                    }
                } else {
                    player.sendMessage(veranyCore.getPrefix() + "§cYou have no one to reply to!");
                }
            } else {
                player.sendMessage("§cUsage: /reply (msg)");
            }
        }
    }
}
