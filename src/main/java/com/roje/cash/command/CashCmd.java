package com.roje.cash.command;

import com.roje.cash.util.CashUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CashCmd implements CommandExecutor {
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
        Player target;
        CashUtil cashUtil;
        Long amount;



        switch (args[0]) {
            case "add", "더하기" -> {
                //TODO 돈 추가
                if (args.length < 3) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }
                if (!args[2].matches("[^0-9]")) {
                    player.sendMessage("§c금액은 숫자만 입력할 수 있습니다");
                    return true;
                }

                target = player.getServer().getPlayer(args[1]);
                amount = Long.parseLong(args[2]);
                cashUtil = new CashUtil(player);

                if (target == null) {
                    player.sendMessage("§c해당 플레이어를 찾을 수 없습니다");
                    return true;
                }
                if (amount < 0) {
                    player.sendMessage("§c금액은 0보다 작을 수 없습니다");
                    return true;
                }

                cashUtil.addCash(target, amount);
                player.sendMessage("§6" + target.getName() + "§f님의 돈을 §a" + amount + "§f캐시를 추가했습니다");
                return true;
            }

            case "subtract", "차감" -> {
                //TODO 돈 빼기
                if (args.length < 3) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }
                if (!args[2].matches("[^0-9]]")) {
                    player.sendMessage("§c금액은 숫자만 입력할 수 있습니다");
                    return true;
                }

                target = player.getServer().getPlayer(args[1]);
                amount = Long.parseLong(args[2]);
                cashUtil = new CashUtil(player);

                if (!player.isOp()) {
                    player.sendMessage("§c당신은 권한이 없습니다");
                }
                if (target == null) {
                    player.sendMessage("§c해당 플레이어를 찾을 수 없습니다");
                    return true;
                }
                if (amount < 0) {
                    player.sendMessage("§c금액은 0보다 작을 수 없습니다");
                    return true;
                }

                cashUtil.subtractCash(target, amount);
                player.sendMessage("§6" + target.getName() + "§f님의 돈을 §a" + amount + "§f캐시를 차감했습니다");
                return true;
            }

            case "set", "설정" -> {
                //TODO 돈 설정
                if (args.length < 2) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }
                if (!args[2].matches("[^0-9]]")) {
                    player.sendMessage("§c금액은 숫자만 입력할 수 있습니다");
                    return true;
                }

                target = player.getServer().getPlayer(args[1]);
                amount = Long.parseLong(args[2]);
                cashUtil = new CashUtil(player);

                if (!player.isOp()) {
                    player.sendMessage("§c당신은 권한이 없습니다");
                }
                if (target == null) {
                    player.sendMessage("§c해당 플레이어를 찾을 수 없습니다");
                    return true;
                }
                if (amount < 0) {
                    player.sendMessage("§c금액은 0보다 작을 수 없습니다");
                    return true;
                }

                cashUtil.setCash(target, amount);
                player.sendMessage("§6" + target.getName() + "§f님의 돈을 §a" + amount + "§f캐시로 설정했습니다");
                return true;
            }

            case "check", "확인" -> {
                //TODO 돈 확인
                if (args.length < 2) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }

                target = player.getServer().getPlayer(args[1]);
                cashUtil = new CashUtil(player);

                if (!player.isOp()) {
                    player.sendMessage("§c당신은 권한이 없습니다");
                }
                if (target == null) {
                    player.sendMessage("§c해당 플레이어를 찾을 수 없습니다");
                    return true;
                }

                player.sendMessage("" + cashUtil.getCash(target));
                return true;
            }

            case "reset", "초기화" -> {
                //TODO 돈 초기화
                if (args.length < 2) {
                    player.sendMessage("§c명령어를 올바르게 입력해주세요");
                    return true;
                }

                target = player.getServer().getPlayer(args[1]);
                cashUtil = new CashUtil(player);

                if (!player.isOp()) {
                    player.sendMessage("§c당신은 권한이 없습니다");
                }


                cashUtil.setCash(target, 0L);
                player.sendMessage("§6" + target.getName() + "§f님의 돈을 §c초기화 §f했습니다");
                return true;
            }

            default -> {
                //TODO 도움말 출력
                return true;
            }
        }


    }
}
