package net.saikatsune.veranycore.spigot.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.getName().length() > 16) {
            player.getName().substring(0, 16);
        }

        if(player.hasPermission("verany.*")) {
            player.setPlayerListName("§c" + player.getName());
        } else if(player.hasPermission("verany.staff")) {
            player.setPlayerListName("§5" + player.getName());
        } else if(player.hasPermission("verany.trial")) {
            player.setPlayerListName("§e" + player.getName());
        } else if(player.hasPermission("verany.media")) {
            player.setPlayerListName("§d" + player.getName());
        } else if(player.hasPermission("verany.donator")) {
            player.setPlayerListName("§6" + player.getName());
        } else {
            player.setPlayerListName("§9" + player.getName());
        }

    }

}
