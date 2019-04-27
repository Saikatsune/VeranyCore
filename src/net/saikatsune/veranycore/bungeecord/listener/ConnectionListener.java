package net.saikatsune.veranycore.bungeecord.listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.saikatsune.veranycore.bungeecord.data.VeranyCore;

public class ConnectionListener implements Listener {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    @EventHandler
    public void onLoginEvent(ServerConnectedEvent e) {
        ProxiedPlayer player = e.getPlayer();

        veranyCore.getReceiveMessageHash().put(player, true);
    }

}
