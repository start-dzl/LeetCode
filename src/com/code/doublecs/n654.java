package com.code.doublecs;

import com.code.TreeNode;

public class n654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] num, Integer start, Integer end) {
        if(start > end) {
            return null;
        }

        if(start.equals(end)) {
             return new TreeNode(num[start]);
        }

        Integer max = start;
        for (int i = start; i <= end; i++) {

            if(num[i] > num[max]) {
                max = i;
            }
        }

        TreeNode node = new TreeNode(num[max]);
        node.left = constructMaximumBinaryTree(num, start, max - 1);
        node.right = constructMaximumBinaryTree(num, max + 1, end);

        return node;

    }
}
