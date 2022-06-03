package com.code.bfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class n111v1 {

    public int minDepth(TreeNode root) {
        int deepint = 0;
        if(Objects.isNull(root)){
            return deepint;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            deepint ++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(Objects.isNull(poll.left)&& Objects.isNull(poll.right)) {
                    return deepint;
                }else {
                    if(!Objects.isNull(poll.left)) {
                        queue.add(poll.left);
                    }

                    if(!Objects.isNull(poll.right)) {
                        queue.add(poll.right);
                    }
                }
            }

        }

        return deepint;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
