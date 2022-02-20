package com.code.doublecs;

public class n116 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        connectDouble(root.left, root.right);

        return root;
    }

    private void connectDouble(Node left, Node right) {
        if(left == null || right == null) {
            return ;
        }
        left.next = right;

        connectDouble(left.left, left.right);
        connectDouble(right.left, right.right);
        connectDouble(left.right, right.left);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
