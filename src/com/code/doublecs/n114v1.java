package com.code.doublecs;

import com.code.TreeNode;

import java.util.Objects;

public class n114v1 {

    public void flatten(TreeNode root) {

        if (Objects.isNull(root)) {
            return;
        }
        nodeToList(root);
    }

    public TreeNode nodeToList(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }

        TreeNode left = nodeToList(root.left);
        TreeNode right = nodeToList(root.right);
        root.left = null;
        if(Objects.isNull(left)){
            root.right = right;
            return root;
        }
        if(Objects.isNull(right)){
            root.right = left;
            return root;
        }

        root.right = left;
        TreeNode lastLeft = left;
        while (!Objects.isNull(lastLeft.right)){
            lastLeft = lastLeft.right;
        }
        lastLeft.right = right;
        return root;

    }
}
