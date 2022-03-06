package com.code.dp;

public class n300 {

    public int lengthOfLIS(int[] nums) {

        int length = nums.length;

        if (length == 0 || length == 1) {
            return length;
        }
        int[] dp = new int[length];
        dp[1] = 1;
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if(num>max) {
                dp[i] = dp[i-1] + 1;
                max = num;
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[length -1];
    }
}
