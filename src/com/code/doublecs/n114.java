package com.code.doublecs;

public class n114 {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {

        if(root == null) {
            return;
        }
        flattenF(root);

    }

    private TreeNode flattenF(TreeNode treeNode) {
        if (treeNode.left == null&& treeNode.right == null) {
            return treeNode;
        }
        TreeNode left = treeNode.left;
        TreeNode nodeLeftEnd = null;
        if(left!=null) {
            nodeLeftEnd = flattenF(left);
        }
        TreeNode right = treeNode.right;
        TreeNode rightEnd = null;
        if(right!=null) {
            rightEnd = flattenF(right);
            if(left!= null) {
                treeNode.left = null;
                treeNode.right = left;
                nodeLeftEnd.right = right;
            }
        }else {
            treeNode.left = null;
            treeNode.right = left;
            rightEnd = nodeLeftEnd;
        }



        return rightEnd;
    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
