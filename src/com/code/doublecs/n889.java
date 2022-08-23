package com.code.doublecs;

import com.code.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class n889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return constructFromPrePost(preorder, 0, postorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int startPre, int endPre , int[] postorder, int startPo, int endPo) {

        if(startPre> endPre) {
            return null;
        }
        if(startPre == endPre) {
            return new TreeNode(preorder[endPre]);
        }

        int head = preorder[startPre];
        TreeNode node = new TreeNode(head);
        int size = 0;  int max = endPre - startPre;
        for (int i = 0; i <= max; i++) {
            size = i;
            Map<Integer, Object> hashMap = new HashMap<>();
            for (int j = startPre+1; j <= (startPre+1+i); j++) {
                hashMap.put(preorder[j], j);
            }

            for (int j = startPo; j <= (startPo+i); j++) {
                hashMap.remove(postorder[j]);
            }

            if(hashMap.isEmpty()) {
                break;
            }
        }

        node.left = constructFromPrePost(preorder, startPre+1, startPre+1+size, postorder, startPo, startPo+size);
        node.right = constructFromPrePost(preorder, startPre+2+size, endPre, postorder, startPo+size+1, endPo);
        return node;
    }
}
