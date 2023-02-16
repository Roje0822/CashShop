package com.roje.cash.util;

import com.roje.cash.CashMain;
import com.roje.cash.data.CashShopMap;
import com.roje.cash.data.GuiType;
import com.roje.rojelib.data.Config;
import com.roje.rojelib.utils.InventoryUtil;
import org.bukkit.entity.Player;

public class CashShopUtil {

    private Player player;

    public CashShopUtil(Player player) {
        this.player = player;
    }


    public void openShop(String name) {
        //TODO 상점 열기
        InventoryUtil inventoryUtil = new InventoryUtil(player);
        inventoryUtil.openInventory(name, 54);
        CashShopMap.CashShopMap.put(player, GuiType.OPEN);
    }


    public void editShop(String name) {
        //TODO 상점 편집
        InventoryUtil inventoryUtil = new InventoryUtil(player);
        inventoryUtil.openInventory(name, 54);
        CashShopMap.CashShopMap.put(player, GuiType.EDIT);
    }


    public void isShopExist(String name) {
        //TODO 상점 존재 여부
        Config config = new Config("shop/" + name, CashMain.getPlugin());
    }
}
