package src.Tree;

public class SumOfNodesInBinaryTree {
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

    static int addBT(Node node) {
        if(node == null) {
            return 0;
        }

        int leftval = addBT(node.left);
        int rightval = addBT(node.right);
        return node.data+leftval+rightval;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int sum = addBT(root);
        System.out.println("Sum of all the elements is: " + sum);
    }
}
