package com.code.dfs;

import java.util.*;

public class n78 {

    List<List<Integer>> results;

    public List<List<Integer>> subsets(int[] nums) {
        results = new ArrayList<>();
        results.add(new LinkedList<>());
        dp(nums, new HashSet<>(), 0);

        return results;
    }

    public void dp(int[] nums, HashSet<Integer> path,int start) {

        if(start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            results.add(new ArrayList<>(path));
            dp(nums, path, i + 1);
            path.remove(num);
        }

    }
}
