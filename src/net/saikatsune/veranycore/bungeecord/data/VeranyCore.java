package net.saikatsune.veranycore.bungeecord.data;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.saikatsune.veranycore.bungeecord.commands.connection.HubCommand;
import net.saikatsune.veranycore.bungeecord.commands.connection.PingCommand;
import net.saikatsune.veranycore.bungeecord.commands.messages.MessageCommand;
import net.saikatsune.veranycore.bungeecord.commands.messages.ReplyMessage;
import net.saikatsune.veranycore.bungeecord.commands.messages.ToggleMessageCommand;
import net.saikatsune.veranycore.bungeecord.commands.staff.ReportCommand;
import net.saikatsune.veranycore.bungeecord.commands.staff.StaffChatCommand;
import net.saikatsune.veranycore.bungeecord.listener.ConnectionListener;

import java.util.HashMap;

public class VeranyCore extends Plugin {

    private static VeranyCore instance;

    private String prefix;

    private HashMap<ProxiedPlayer, ProxiedPlayer> replyHash;
    private HashMap<ProxiedPlayer, Boolean> receiveMessageHash;

    @Override
    public void onEnable() {
        instance = this;

        prefix = "§7> §a§lVeranyMC §7| ";

        replyHash = new HashMap<>();
        receiveMessageHash = new HashMap<>();

        init(BungeeCord.getInstance().getPluginManager());
    }

    private void init(PluginManager pluginManager) {
        pluginManager.registerCommand(this, new HubCommand());
        pluginManager.registerCommand(this, new PingCommand());

        pluginManager.registerCommand(this, new MessageCommand());
        pluginManager.registerCommand(this, new ReplyMessage());
        pluginManager.registerCommand(this, new ToggleMessageCommand());

        pluginManager.registerCommand(this, new ReportCommand());
        pluginManager.registerCommand(this, new StaffChatCommand());

        pluginManager.registerListener(this, new ConnectionListener());
    }

    public static VeranyCore getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public HashMap<ProxiedPlayer, ProxiedPlayer> getReplyHash() {
        return replyHash;
    }

    public HashMap<ProxiedPlayer, Boolean> getReceiveMessageHash() {
        return receiveMessageHash;
    }
}
