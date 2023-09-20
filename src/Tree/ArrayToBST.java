package src.Tree;

public class ArrayToBST {
    class Node{
        int data;
        Node left,right;

        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    Node sortedArrayToBST(int[] arr, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;

        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr,start,mid-1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr,mid+1,end);

        return node;
    }

    void preorder(Node node){
        if(node==null){
            return;
        }

        System.out.print(node.data + "");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        ArrayToBST tree = new ArrayToBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preorder(root);

    }
}
