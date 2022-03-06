package com.code.dp;

import java.util.Arrays;

public class n74 {

    private static int[][] memo;

    public static int calculateMinimumHP(int[][] dungeon) {
        int i = dungeon.length;
        if (i == 0) {
            return 1;
        }

        int j = dungeon[0].length;
        memo = new int[i][j];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(dungeon, 0, 0);
    }

    private static int dp(int[][] dungeon, int i, int j) {
        int il = dungeon.length - 1;
        int jl = dungeon[0].length - 1;
        int dg = dungeon[i][j];

        if (i == il && j == jl) {
            return getNum(dg, 1);
        }

        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        Integer dpi = null;
        if (i < il) {
            dpi = dp(dungeon, i + 1, j);
        }
        Integer dpz = null;
        if (j < jl) {
            dpz = dp(dungeon, i, j + 1);
        }

        if (dpi == null) {
            int num = getNum(dg, dpz);
            memo[i][j] = num;
            return num;
        }

        if (dpz == null) {
            int num = getNum(dg, dpi);
            memo[i][j] = num;
            return num;
        }

        int min = Math.min(dpi, dpz);
        int num = getNum(dg, min);
        memo[i][j] = num;
        return num;

    }

    private static int getNum(int dg, int addDg) {
        int i = -dg + addDg;
        if (i<=0) {
            return 1;
        } else {
            return i;
        }
    }
}
