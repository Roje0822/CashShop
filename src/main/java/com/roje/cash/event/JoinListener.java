package com.roje.cash.event;

import com.roje.cash.CashMain;
import com.roje.rojelib.data.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Config config = new Config("data/" + player.getUniqueId(), CashMain.getPlugin());
        if (!config.isFileExist()) {
            config.setLong("cash", 0L);
        }
    }
}
