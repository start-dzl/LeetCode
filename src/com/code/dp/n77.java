package com.code.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class n77 {

    List<List<Integer>> results;

    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n ; i++) {
            nums[i-1] = i;
        }
        dp(nums, new HashSet<>(), 0, k);

        return results;
    }

    public void dp(int[] nums, HashSet<Integer> path,int start, int k) {

        if(path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            dp(nums, path, i + 1, k);
            path.remove(num);
        }

    }
}
