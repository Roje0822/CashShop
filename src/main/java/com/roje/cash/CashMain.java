package com.roje.cash;

import com.roje.cash.command.CashCmd;
import com.roje.cash.command.CashTabCompleter;
import com.roje.cash.event.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CashMain extends JavaPlugin {

    CashMain plugin;

    @Override
    public void onEnable() {
        init();
    }


    private void init() {

        // command
        getCommand("cash").setExecutor(new CashCmd());
        getServer().getPluginCommand("cash").setTabCompleter(new CashTabCompleter());

        // event
        getServer().getPluginManager().registerEvents(new JoinListener(), this);


        // config
        plugin = this;
        saveConfig();
        saveDefaultConfig();
    }


    public static CashMain getPlugin() {
        return getPlugin(CashMain.class);
    }
}
