package src.Tree;

public class BoundaryTraversal {
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

    Node root;

    void printBoundary(Node node) {
        if(node == null) {
            return;
        }

        printLeftBoundary(node);
        printLeaves(node);
        printRightBoundary(node.right);
    }

    void printLeftBoundary(Node node) {
        if(node == null) {
            return;
        }

        if(node.left!=null) {
            System.out.println(node.data);
            printLeftBoundary(node.left);
        }
        else if(node.right!= null) {
            System.out.println(node.data);
            printLeftBoundary(node.right);
        }
    }

    void printRightBoundary(Node node) {
        if(node == null) {
            return;
        }

        if(node.right!=null) {
            System.out.println(node.data);
            printRightBoundary(node.right);
        }
        else if(node.left!=null) {
            System.out.println(node.data);
            printRightBoundary(node.left);
        }
    }

    void printLeaves(Node node) {
        if(node == null) {
            return;
        }

        if(node.left==null && node.right==null) {
            System.out.println(node.data);
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    public static void main(String args[])
    {
            BoundaryTraversal tree = new BoundaryTraversal();
            tree.root = new Node(20);
            tree.root.left = new Node(8);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(12);
            tree.root.left.right.left = new Node(10);
            tree.root.left.right.right = new Node(14);
            tree.root.right = new Node(22);
            tree.root.right.right = new Node(25);
            tree.printBoundary(tree.root);
    }

}
