package com.code.doublecs;

import com.code.TreeNode;

import java.util.Objects;

public class n226 {

    public TreeNode invertTree(TreeNode root) {

        if(Objects.isNull(root)){
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;


    }
}
