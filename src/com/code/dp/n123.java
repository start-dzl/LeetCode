package com.code.dp;

public class n123 {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j-1][0] - prices[i], dp[i - 1][j][1]);
            }

        }

        int[][] ints = dp[prices.length - 1];
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            max = Math.max(ints[i][0], max);
        }

        return max;

    }
}
