package com.code.dfs;

import java.util.*;

public class n46 {

    private List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        perm(nums, linkedList);
        return paths;
    }

    private void perm(int[] nums, LinkedList<Integer> node) {

        int length = nums.length;

        if (node.size() == length) {
            paths.add(new ArrayList<>(node));
            return;
        }

        for (int j = 0; j < length; j++) {
            int i1 = nums[j];
            if (!node.contains(i1)) {
                node.addLast(i1);
                perm(nums, node);
                node.removeLast();
            }
        }

    }
}
