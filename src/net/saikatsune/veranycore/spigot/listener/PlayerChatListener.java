package net.saikatsune.veranycore.spigot.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        if(player.hasPermission("verany.*")) {
            e.setFormat("§8(§cAdmin§8) §c" + player.getName() + ": §f" + e.getMessage());
        } else if(player.hasPermission("verany.staff")) {
            e.setFormat("§8(§5Staff§8) §5" + player.getName() + ": §f" + e.getMessage());
        } else if(player.hasPermission("verany.trial")) {
            e.setFormat("§8(§eTrial§8) §e" + player.getName() + ": §f" + e.getMessage());
        } else if(player.hasPermission("verany.media")) {
            e.setFormat("§8(§dMedia§8) §d" + player.getName() + ": §f" + e.getMessage());
        } else if(player.hasPermission("verany.donator")) {
            e.setFormat("§8(§6Donator§8) §6" + player.getName() + ": §f" + e.getMessage());
        } else {
            e.setFormat("§9" + player.getName() + ": §f" + e.getMessage());
        }

    }

}
