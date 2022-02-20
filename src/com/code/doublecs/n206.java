package com.code.doublecs;

public class n206 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode right = root.right;
        root.right = root.left;
        root.left =  right;
        invertTree(root.right);
        invertTree(root.left);
        return root;
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
