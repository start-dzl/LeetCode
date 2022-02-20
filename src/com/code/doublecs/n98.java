package com.code.doublecs;

public class n98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
       return isValidBst(root, null, null);

    }

    public boolean isValidBst(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }

        if (max != null && max.val <= root.val) {
            return false;
        }

        if (min != null && min.val >= root.val) {
            return false;
        }

        return isValidBst(root.left, root, min) && isValidBst(root.right, max, root);
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
