package com.code.doublecs;

import com.code.TreeNode;

import java.util.Objects;

public class n669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (Objects.isNull(root)) {
            return root;
        }
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (root.val >= low && root.val <= high) {
            //符合条件
            root.left = left;
            root.right = right;
            return root;
        }else if(Objects.isNull(left)){
            return right;
        }else if(Objects.isNull(right)) {
            return left;
        }else {
            TreeNode minRight = right;
            while (!Objects.isNull(minRight.left)){
                minRight = minRight.left;
            }
            minRight.left = left;
            return right;
        }
    }
}
