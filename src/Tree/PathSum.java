package src.Tree;

public class PathSum {

    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public boolean hasPathSum(Node root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && targetSum - root.data == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.data) ||
                hasPathSum(root.right, targetSum - root.data);
    }

    public static void main(String[] args) {
        int sum = 21;

        PathSum tree = new PathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        // Function call
        if (tree.hasPathSum(tree.root, sum))
            System.out.println(
                    "There is a root to leaf path with sum "
                            + sum);
        else
            System.out.println(
                    "There is no root to leaf path with sum "
                            + sum);
    }
}
