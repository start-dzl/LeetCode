package com.code.doublecs;

import com.code.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class n106 {

    public Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int startIn, int endIn,
                              int[] postorder,int startPo,int endPo) {
        if(startPo> endPo){
            return null;
        }
        if(startPo == endPo) {
            return new TreeNode(postorder[startPo]);
        }
        int i = postorder[endPo];
        TreeNode node = new TreeNode(i);

        Integer index = map.get(i);

        int length = index - startIn;

        node.left = buildTree(inorder, startIn, index -1, postorder, startPo, startPo+length-1);
        node.right = buildTree(inorder, index+1, endIn, postorder, startPo+length, endPo-1);
        return node;
    }
}
