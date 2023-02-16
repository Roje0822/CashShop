package com.roje.cash.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CashTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) {
            return List.of("더하기", "차감", "설정", "확인", "초기화", "도움말");
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("더하기") || args[0].equalsIgnoreCase("차감") || args[0].equalsIgnoreCase("설정") || args[0].equalsIgnoreCase("초기화")
                    || args[0].equalsIgnoreCase("확인") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("subtract") || args[0].equalsIgnoreCase("set")
                    || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("check")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    return List.of(player.getName());
                }
            }
        }
        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("더하기") || args[0].equalsIgnoreCase("차감") || args[0].equalsIgnoreCase("설정") || args[0].equalsIgnoreCase("초기화")
                    || args[0].equalsIgnoreCase("확인") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("subtract") || args[0].equalsIgnoreCase("set")
                    || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("check")) {
                return List.of("<amount>");
            }
        }

        return Collections.emptyList();
    }
}
