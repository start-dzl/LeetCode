package com.code.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class n111 {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> objects = new LinkedList<>();
        objects.offer(root);
        int dep = 1;
        while (!objects.isEmpty()){
            int size = objects.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = objects.poll();
                if(poll.left==null && poll.right==null){
                    return dep;
                }
                if(poll.left!=null){
                    objects.offer(poll.left);
                }

                if(poll.right!=null){
                    objects.offer(poll.right);
                }
            }
            dep++;

        }
        return dep;
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
