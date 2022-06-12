package com.code.dp;

import java.util.*;

public class n47 {
    List<List<Integer>> results;

    boolean[] dp;

    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new ArrayList<>();
        dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        Arrays.sort(nums);
        dp(nums, new LinkedList<>());

        return results;
    }

    public void dp(int[] nums, LinkedList<Integer> path) {

        if(path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!hashSet.contains(num)&& !dp[i]) {
                dp[i] =true;
                path.addLast(num);
                dp(nums, path);
                path.removeLast();
                dp[i] = false;
                hashSet.add(num);
            }


        }
    }
}
