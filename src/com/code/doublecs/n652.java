package com.code.doublecs;

import com.code.TreeNode;

import java.util.*;

public class n652 {

    private String con = ",";

    private String kong = "#";

    private Map<String, Integer> map = new HashMap<>();

    private List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return list;
    }

    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return kong;
        }

        String left = serialize(root.left);

        String right = serialize(root.right);

        String rootStr = left + con + right + con + root.val;

        if(map.containsKey(rootStr)) {

            if(map.get(rootStr) == 1) {
                list.add(root);
            }
            map.put(rootStr, map.get(rootStr)+1);

        }else {
            map.put(rootStr, 1);
        }
        return rootStr;
    }

}
