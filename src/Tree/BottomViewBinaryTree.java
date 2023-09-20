package src.Tree;

import java.util.*;

public class BottomViewBinaryTree {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static Node root;

    class Qobj{
        int hd;
        Node node;

        Qobj(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    void TopView(Node root) {
        if(root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Qobj> queue = new LinkedList<>();

        queue.add(new Qobj(0,root));

        while(!queue.isEmpty()) {
            Qobj temp = queue.poll();
            int hd = temp.hd;
            Node node = temp.node;

            map.put(hd,node.data);

            if(node.left!=null){
                queue.add(new Qobj(hd-1,node.left));
            }

            if(node.right!=null){
                queue.add(new Qobj(hd+1,node.right));
            }

        }

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }


    public static void main(String[] args) {
        BottomViewBinaryTree tree = new BottomViewBinaryTree();
        tree.root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(
                "Following are nodes in bottom view of Binary Tree");
        tree.TopView(tree.root);
    }
}
