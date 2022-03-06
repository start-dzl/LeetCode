package com.code.dp;

import java.util.*;

public class n78 {

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> allpath = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        setHelp(nums, -1);
        return allpath;
    }

    private void setHelp(int[] nums, int i) {
        int length = nums.length;
        if (i >= length) {
            return;
        }
        allpath.add(new LinkedList<>(path));

        for (int j = i + 1; j < length; j++) {
            path.addLast(nums[j]);
            setHelp(nums, j);
            path.removeLast();
        }

    }


}
