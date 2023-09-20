package src.Tree;

public class MirrorTree {
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

    Node node;

    Node mirrorTree(Node node) {
        if(node == null) {
            return null;
        }

        Node left = mirrorTree(node.left);
        Node right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    //Inorder traversal
    static void printTree(Node node) {
        if (node == null)
            return;

        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);

    }

    public static void main(String[] args) {
       MirrorTree tree = new MirrorTree();
       tree.node = new Node(1);
       tree.node.left = new Node(2);
       tree.node.right = new Node(3);
       tree.node.left.left = new Node(4);
       tree.node.left.right = new Node(5);

       printTree(tree.node);
       System.out.println("");

       Node mirror = tree.mirrorTree(tree.node);
       printTree(mirror);

    }
}
