package com.code.dp;

import java.util.*;

public class n39 {

    List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        dp(candidates, new LinkedList<>(), 0, target, 0);
        return results;
    }

    public void dp(int[] nums, LinkedList<Integer> path, int pathCount, int target, int start) {

        if (pathCount == target) {
            results.add(new ArrayList<>(path));
            return;
        } else if (pathCount > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            path.addLast(num);
            pathCount = pathCount + num;
            dp(nums, path, pathCount, target, i);
            pathCount = pathCount - num;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        boolean[] pd = new boolean[20];
        StringBuilder sb = new StringBuilder();
        for (boolean b : pd) {
            sb.append(b);
        }
        System.out.println(sb.toString());
    }
}
