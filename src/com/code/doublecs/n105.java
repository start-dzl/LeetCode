package com.code.doublecs;

import com.code.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class n105 {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
       return buildTree(preorder, inorder, 0, preorder.length-1,0, inorder.length );
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              Integer preStart, Integer preEnd,
                              Integer inStart, Integer inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int i = preorder[preStart];
        TreeNode treeNode = new TreeNode(i);
        Integer inorderIndex = map.get(i);
        //找到对应值的位置
        int leftNum = inorderIndex - inStart;
        //left
        treeNode.left = buildTree(preorder, inorder, preStart + 1, preStart + leftNum, inStart, inorderIndex - 1);
        //right

        treeNode.right = buildTree(preorder, inorder, preStart + leftNum + 1, preEnd, inorderIndex + 1, inEnd);

        return treeNode;
    }
}
