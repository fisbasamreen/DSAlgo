package src.Tree;

public class BinaryTreeToDLL {
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
    Node head;
    Node prev = null;

    void BinaryTree2DoubleLinkedList(Node node){
        if(node==null){
            return;
        }
        Node curr = node;

        BinaryTree2DoubleLinkedList(curr.left);

        if(prev == null) {
            head = curr;
        } else{
            curr.left = prev;
            prev.right = curr;
        }

        prev = curr;

        BinaryTree2DoubleLinkedList(curr.right);
    }

    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }
}
