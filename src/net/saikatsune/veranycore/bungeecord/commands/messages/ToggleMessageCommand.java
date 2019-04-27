package net.saikatsune.veranycore.bungeecord.commands.messages;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class ToggleMessageCommand extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    public ToggleMessageCommand() {
        super("togglemessage", "", "togglemsg", "togglepm");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(veranyCore.getReceiveMessageHash().get(player).equals(false)) {
                veranyCore.getReceiveMessageHash().put(player, true);
                player.sendMessage(veranyCore.getPrefix() + "§aYou will now receive private messages!");
            } else {
                veranyCore.getReceiveMessageHash().put(player, false);
                player.sendMessage(veranyCore.getPrefix() + "§cYou will no longer receive private messages!");
            }
        }
    }
}
