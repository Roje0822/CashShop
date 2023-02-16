package com.roje.cash.util;


import com.roje.cash.CashMain;
import com.roje.rojelib.data.Config;
import org.bukkit.entity.Player;

public class CashUtil {

    private Long amount;
    private Player player;
    private Player target;
    private Config config;


    public CashUtil(Player player) {
        this.player = player;
        this.config = new Config("data/" + player.getUniqueId(), CashMain.getPlugin());
    }

    public void subtractCash(Player target, Long amount) {
        Config config = new Config("data/" + target.getUniqueId(), CashMain.getPlugin());
        config.setLong("cash", config.getLong("cash") - amount);
    }


    public void addCash(Player target, Long amount) {
        Config config = new Config("data/" + target.getUniqueId(), CashMain.getPlugin());
        config.setLong("cash", config.getLong("cash") + amount);
    }


    public void setCash(Player target, Long amount) {
        Config config = new Config("data/" + target.getUniqueId(), CashMain.getPlugin());
        config.setLong("cash", amount);
    }


    public Long getCash(Player target) {
        Config config = new Config("data/" + target.getUniqueId(), CashMain.getPlugin());
        return config.getLong("cash");
    }





}
