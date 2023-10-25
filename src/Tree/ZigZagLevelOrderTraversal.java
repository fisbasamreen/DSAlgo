package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

   Node root;
    public static ArrayList<Integer> ZigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flagLefttoRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i< size ;i++) {
                Node current = queue.poll();
                if (flagLefttoRight) {
                    currentLevel.add(current.data); // Add nodes left to right
                } else {
                    currentLevel.add(0, current.data); // Add nodes right to left
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            flagLefttoRight = !flagLefttoRight;
            result.addAll(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal tree = new ZigZagLevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Zig Zag Level order traversal of"
                + "binary tree is ");
        ArrayList<Integer> ans = ZigZagTraversal(tree.root);
        for(Integer i : ans) {
            System.out.print(i + " ");
        }
    }
}
