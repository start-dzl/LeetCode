package com.code.doublecs;

import com.code.TreeNode;

import javax.management.ObjectName;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class n297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode end = root;
        while (!Objects.isNull(end)) {
            end = null;
            int i1 = queue.size();
            for (int i = 0; i < i1; i++) {
                TreeNode poll = queue.poll();
                if (Objects.isNull(poll)) {
                    result.append("null,");
                } else {
                    result.append(poll.val).append(",");
                    if (!Objects.isNull(poll.left)) {
                        end = poll.left;
                    }
                    if (!Objects.isNull(poll.right)) {
                        end = poll.right;
                    }
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }

        }

        return "[" + result.substring(0, result.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String substring = data.substring(1, data.length() - 1);
        if (substring.isEmpty()) {
            return null;
        }
        String[] strings = substring.split(",");
        String str = strings[0];
        if ("null".equals(str) || "".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        Integer num = 1;
        while (num < strings.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                String left = strings[num];
                num++;
                String right = strings[num];
                num++;
                if ("null".equals(left) || "".equals(left)) {

                } else {
                    TreeNode nodeleft = new TreeNode(Integer.valueOf(left));
                    poll.left = nodeleft;
                    queue.add(nodeleft);
                }

                if ("null".equals(right) || "".equals(right)) {

                } else {
                    TreeNode noderight = new TreeNode(Integer.valueOf(right));
                    poll.right = noderight;
                    queue.add(noderight);
                }
            }

        }

        return node;
    }

    public static void main(String[] args) {
        String s = "[1,2,3,null,null,4,5]";
        n297 n297 = new n297();
        TreeNode treeNode = n297.deserialize(s);
        String serialize = n297.serialize(treeNode);
        System.out.println(serialize);
    }
}
