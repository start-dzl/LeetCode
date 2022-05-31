package com.code.dfs;

import java.util.*;

public class n46v1 {

    List<List<Integer>> results;

    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        this.results = arrayList;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        permuteDfs(path,nums, used);

        return results;
    }

    public void permuteDfs(LinkedList<Integer> path, int[] nums, boolean[] use) {
        if(path.size() == nums.length){
            results.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length ; i++) {
            if(!use[i]) {
                path.add(nums[i]);
                use[i] = true;
                permuteDfs(path,nums, use);
                path.removeLast();
                use[i] = false;
            }
        }

    }
}
