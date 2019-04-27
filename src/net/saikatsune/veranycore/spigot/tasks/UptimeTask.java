package net.saikatsune.veranycore.spigot.tasks;

import net.saikatsune.veranycore.spigot.data.VeranyCore;
import org.bukkit.Bukkit;

public class UptimeTask {

    private VeranyCore veranyCore = VeranyCore.getInstance();

    private int uptimeHours;
    private int uptimeMinutes;
    private int uptimeSeconds;

    private int taskID;

    public void start() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(veranyCore, new Runnable() {
            @Override
            public void run() {
                uptimeSeconds++;

                if(uptimeSeconds == 60) {
                    uptimeSeconds = 0;
                    uptimeMinutes = uptimeMinutes + 1;
                    if(uptimeMinutes == 60) {
                        uptimeMinutes = 0;
                        uptimeHours = uptimeHours + 1;
                    }
                }

            }
        }, 0, 20);
    }

    public void stop() {
        Bukkit.getScheduler().cancelTask(taskID);
    }

    public String getFormattedTime() {
        String formattedTime = "";

        if(uptimeHours < 10)
            formattedTime += "0";
        formattedTime += uptimeHours + ":";

        if (uptimeMinutes < 10)
            formattedTime += "0";
        formattedTime += uptimeMinutes + ":";

        if (uptimeSeconds < 10)
            formattedTime += "0";
        formattedTime += uptimeSeconds;

        return formattedTime;
    }

}
