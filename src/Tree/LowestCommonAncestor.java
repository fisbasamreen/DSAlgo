package src.Tree;

public class LowestCommonAncestor {
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

    Node findLCA(Node root, int node1, int node2) {
        if(root == null) {
            return null;
        }

        if(root.data == node1 || root.data == node2) {
            return root;
        }

         Node left = findLCA(root.left,node1,node2);
         Node right = findLCA(root.right,node1,node2);

        if(left!=null && right!=null) {
            return root;
        } else {
            return left!=null ? left : right;
        }

    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(root,4,5).data);
        System.out.println("LCA(4, 6): " + tree.findLCA(root,4,6).data);
        System.out.println("LCA(3, 4): " + tree.findLCA(root, 3,4).data);
        System.out.println("LCA(2, 4): " + tree.findLCA(root,2,4).data);
    }
}
