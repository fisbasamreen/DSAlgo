package src.Tree;

public class NumberOfLeaves {
    static class Node{
        int data;
        Node left,right;

        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    static Node node;

    int numberOfLeavesNodes(Node node) {
        if(node == null) {
            return 0;
        }

        if(node.left==null && node.right==null) {
           return 1;
        }

        return numberOfLeavesNodes(node.left) + numberOfLeavesNodes(node.right);
    }

    public static void main(String[] args) {
        NumberOfLeaves tree = new NumberOfLeaves();
        tree.node = new Node(4);
        tree.node.left = new Node(2);
        tree.node.right = new Node(5);
        tree.node.left.left = new Node(1);
        tree.node.left.right = new Node(3);


        System.out.println(tree.numberOfLeavesNodes(tree.node));
    }
}
