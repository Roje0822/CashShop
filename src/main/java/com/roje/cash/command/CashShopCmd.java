package com.roje.cash.command;

import com.roje.cash.util.CashShopUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CashShopCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§c버킷에서는 명령어를 사용 할 수 없습니다");
            return false;
        }

        if (args.length == 0) {
            //TODO 도움말 출력
            return true;
        }

        CashShopUtil cashShopUtil;
        String shopName;

        switch (args[0]) {
            case "open", "열기" -> {
                //TODO 상점 열기

                if (args.length < 2) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }
                if (!args[1].matches("[^가-핳a-zA-Z0-9]")) {
                    player.sendMessage("§c상점 이름이 잘못되었습니다");
                    return true;
                }

                shopName = args[1];
                cashShopUtil = new CashShopUtil(player);

                cashShopUtil.openShop(shopName);
                player.sendMessage("§a" + shopName + " §f상점을 열었습니다");

                return true;
            }

            case "edit", "편집" -> {
                //TODO 상점 편집
                return true;
            }

        }

        return false;
    }
}
