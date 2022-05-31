package com.code.dp;

import java.util.HashMap;
import java.util.Map;

public class n322 {

    static Map<Integer, Integer> dp;

    public static void main(String[] args) {

        int[] ints = {474, 83, 404, 3};
        System.err.println(coinChange(ints, 264));
    }

    public static int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        return dpChange(coins, amount);
    }

    public static int dpChange(int[] coins, int amount ) {
        if (amount == 0) {
            return 0;
        }
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }
        // 第一个硬币和剩下的
        var min = -1;
        for (int coin : coins) {
            if (coin <= amount) {
                int change = dpChange(coins, amount - coin);
                if (change != -1 && min != -1) {
                    min = Math.min(min, change + 1);
                } else if (min == -1 && change != -1) {
                    min = change + 1;
                }
            }
        }
        dp.put(amount, min);
        return min;
    }
}
