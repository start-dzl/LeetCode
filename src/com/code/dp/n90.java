package com.code.dp;

import java.util.*;

public class n90 {

    List<List<Integer>> results;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        results = new ArrayList<>();
        Arrays.sort(nums);
        dp(nums, new LinkedList<>(), 0);

        return results;
    }

    public void dp(int[] nums, LinkedList<Integer> path,int start) {
        results.add(new ArrayList<>(path));
        if(start == nums.length) {
            return;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if(!hashSet.contains(num)) {
                path.addLast(num);
                dp(nums, path, i + 1);
                path.removeLast();
            }
            hashSet.add(num);

        }
    }
}
