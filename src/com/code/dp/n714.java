package com.code.dp;

public class n714 {

    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
            }else {
                dp[i][0] =Math.max(dp[i - 1][0], dp[i-1][1] + prices[i] );
                dp[i][1] =Math.max(dp[i - 1][0] - prices[i]- fee, dp[i-1][1]);
            }
        }
        return dp[prices.length -1][0];

    }
}
