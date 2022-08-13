package com.code.doublecs;

import com.code.TreeNode;

import java.util.Objects;

public class n104 {
    public int maxDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        if(Objects.isNull(root.left)&&Objects.isNull(root.right)){
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max+1;

    }



}
