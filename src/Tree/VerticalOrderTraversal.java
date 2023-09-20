package src.Tree;

import java.util.*;

public class VerticalOrderTraversal {
    class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static class Qobj {
        int hd;
        Node node;
        Qobj(int hd, Node node)
        {
            this.hd = hd;
            this.node = node;
        }
    }

    Node root;

    static void printVerticalOrder(Node root) {
        if (root == null)
            return;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int hd = 0;

        Queue<Qobj> queue = new LinkedList<Qobj>();
        queue.add(new Qobj(0,root));

        while(!queue.isEmpty()) {
            Qobj temp = queue.poll();
            hd = temp.hd;
            Node node = temp.node;


            if (map.containsKey(hd)) {
                map.get(hd).add(node.data);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(node.data);
                map.put(hd, al);
            }

            if(node.left!=null) {
                queue.add(new Qobj(hd-1,node.left));
            }
            if(node.right!=null) {
                queue.add(new Qobj(hd+1,node.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer> > entry : map.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            for (Integer i : al)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.right.left.right = tree.new Node(8);
        tree.root.right.right.right = tree.new Node(9);
        tree.root.right.right.left = tree.new Node(10);
        tree.root.right.right.left.right = tree.new Node(11);
        tree.root.right.right.left.right.right = tree.new Node(12);
        System.out.println("Vertical order traversal is ");
        printVerticalOrder(tree.root);
    }
}
