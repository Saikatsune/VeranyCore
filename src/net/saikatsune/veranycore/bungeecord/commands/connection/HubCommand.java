package net.saikatsune.veranycore.bungeecord.commands.connection;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class HubCommand extends Command {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    public HubCommand() {
        super("hub", "", "lobby", "l");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(!player.getServer().getInfo().getName().equals("LOBBY-01")) {
                player.connect(BungeeCord.getInstance().getServerInfo("LOBBY-01"));
            } else {
                player.sendMessage(veranyCore.getPrefix() + "§cYou're already connected to a lobby-server!");
            }
        }
    }
}
