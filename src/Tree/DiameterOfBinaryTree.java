package src.Tree;

public class DiameterOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight> rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldia = diameter(root.left);
        int rdia = diameter(root.right);

        return Math.max(lheight+rheight+1,Math.max(ldia,rdia));
    }

    int max = 0;
    //Another implementation
    private int maxDepth(Node root) {

        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right+1);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(Node root) {
        maxDepth(root);
        return max;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameter(tree.root));

        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameterOfBinaryTree(tree.root));
    }
}
