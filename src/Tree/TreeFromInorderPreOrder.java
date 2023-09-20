package src.Tree;

import java.util.HashMap;

public class TreeFromInorderPreOrder {
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

    public static Node root;
    static HashMap<Character,Integer> mp = new HashMap<>();
    static int preIndex = 0;

    public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd)
    {

        if(inStrt > inEnd)
        {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex
        and increment preIndex */
        char curr = pre[preIndex++];
        Node tNode;
        tNode = new Node(curr);

        /* If this node has no children then return */
        if (inStrt == inEnd)
        {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = mp.get(curr);

    /* Using index in Inorder traversal, construct left and
        right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }


    public static Node buldTreeWrap(char[] in, char[] pre, int len)
    {
        for(int i = 0; i < len; i++)
        {
            mp.put(in[i], i);
        }
        return buildTree(in, pre, 0, len - 1);
    }

    static void printInorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;

        TreeFromInorderPreOrder.root=buldTreeWrap(in, pre, len);

    /* Let us test the built tree by printing
        Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is");
        printInorder(root);
    }
}
