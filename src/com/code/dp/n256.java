package com.code.dp;

import java.util.Arrays;

public class n256 {

    static int[][] dp;

    public static void main(String[] args) {
        int[][] its= new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}};

        System.err.println(minCost(its));
    }

    public static int minCost(int[][] costs) {
        int length = costs.length;
        dp = new int[length][3];
        if(length == 0 ) {
            return 0;
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }


        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + costs[i][2];

        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            minValue = Math.min(minValue, dp[length -1][i]);
        }

        return minValue;

    }


    public static int dpCost(int[][] costs, int n, int mark) {
        if (n == 0) {
            int[] cost = costs[n];
            return getMin(cost, mark)[0];

        }
        if (mark!= -1 && dp[n][mark] != -1) {
            return dp[n][mark];
        }

        int min = -1;
        int[] cost = costs[n];
        int length = cost.length;
        for (int i = 0; i < length; i++) {
            if (i != mark) {
                int m1 = cost[i] + dpCost(costs, n - 1, i);
                if (min == -1) {
                    min = m1;
                } else {
                    min = Math.min(min, m1);
                }
            }
        }
        if(mark != -1) {
            dp[n][mark] = min;
        }

        return min;
    }

    public static int[] getMin(int[] cost, int mark) {
        int[] ints = new int[2];
        Arrays.fill(ints, -1);
        int length = cost.length;
        for (int i = 0; i < length; i++) {
            if (i != mark) {
                if (ints[0] != -1) {
                    if (cost[i] < ints[0]) {
                        ints[0] = cost[i];
                        ints[1] = i;
                    }
                } else {
                    ints[0] = cost[i];
                    ints[1] = i;
                }
            }
        }
        System.err.println("value = " + ints[0] + "nark = " + ints[1]);
        return ints;
    }
}
