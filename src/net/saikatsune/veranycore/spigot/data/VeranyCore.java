package net.saikatsune.veranycore.spigot.data;

import net.saikatsune.veranycore.spigot.commands.LagCommand;
import net.saikatsune.veranycore.spigot.listener.ConnectionListener;
import net.saikatsune.veranycore.spigot.listener.PlayerChatListener;
import net.saikatsune.veranycore.spigot.tasks.UptimeTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VeranyCore extends JavaPlugin {

    private static VeranyCore instance;

    private String prefix;

    private UptimeTask uptimeTask;

    @Override
    public void onEnable() {
        instance = this;

        prefix = "§7> §a§lVeranyMC §7| ";

        uptimeTask = new UptimeTask();

        init(Bukkit.getPluginManager());

        uptimeTask.start();
    }

    private void init(PluginManager pluginManager) {
        pluginManager.registerEvents(new PlayerChatListener(), this);
        pluginManager.registerEvents(new ConnectionListener(), this);

        getCommand("lag").setExecutor(new LagCommand());
    }

    public static VeranyCore getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public UptimeTask getUptimeTask() {
        return uptimeTask;
    }
}
