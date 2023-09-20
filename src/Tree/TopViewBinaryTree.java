package src.Tree;

import java.util.*;

public class TopViewBinaryTree {
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

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Qobj> queue = new LinkedList<>();

        int hd=0;
        queue.add(new Qobj(0,root));

        while(!queue.isEmpty()) {
            Qobj temp = queue.poll();
            hd = temp.hd;
            Node node = temp.node;

            if(!map.containsKey(hd)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(node.data);
                map.put(hd,al);
            }

            if(node.left!=null){
                queue.add(new Qobj(hd-1,node.left));
            }

            if(node.right!=null){
                queue.add(new Qobj(hd+1,node.right));
            }

        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry :
                map.entrySet()) {
            System.out.print(entry.getValue());
        }


    }


    public static void main(String[] args) {
        TopViewBinaryTree tree = new TopViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println(
                "Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}
