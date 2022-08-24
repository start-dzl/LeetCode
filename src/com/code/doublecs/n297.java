package com.code.doublecs;

import com.code.TreeNode;

import javax.management.ObjectName;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class n297 {

    String split = ",";
    String n = "null";

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
                    result.append(n).append(split);
                } else {
                    result.append(poll.val).append(split);
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
        String[] strings = substring.split(split);
        String str = strings[0];
        if (n.equals(str)) {
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
                if (!n.equals(left)) {
                    TreeNode nodeleft = new TreeNode(Integer.valueOf(left));
                    poll.left = nodeleft;
                    queue.add(nodeleft);
                }

                if (!n.equals(right)) {
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
