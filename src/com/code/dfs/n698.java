package com.code.dfs;

import java.util.*;

public class n698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        int used = 0;
        int target = sum / k;

        return backtrack(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();

    boolean backtrack(int k, int bucket,
                      int[] nums, int start, int used, int target) {

        if (k == 0) {

            return true;
        }
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }

            used |= 1 << i; // 将第 i 位置为 1
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            used ^= 1 << i;
            bucket -= nums[i];
        }

        return false;
    }

}
