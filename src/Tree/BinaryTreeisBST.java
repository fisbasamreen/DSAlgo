package src.Tree;

public class BinaryTreeisBST {
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
    Node prev;

    boolean checkIfBST(Node root){
        if(root == null) {
            return false;
        }

        while (node!=null) {
            if(!checkIfBST(root.left)){
                return false;
            }

            if (prev != null && node.data <= prev.data )
                return false;

            prev = node;

            return checkIfBST(node.right);
        }

        return true;
    }

    private static boolean isBST(Node node, int min, int max) {
        // Base case: An empty tree is a BST.
        if (node == null) {
            return true;
        }

        // Check if the current node's key is within the valid range.
        if (node.data < min || node.data > max) {
            return false;
        }

        // Recursively check the left and right subtrees.
        return isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max);
    }

    public static void main(String args[])
    {
        BinaryTreeisBST tree = new BinaryTreeisBST();
        tree.node = new Node(4);
        tree.node.left = new Node(2);
        tree.node.right = new Node(5);
        tree.node.left.left = new Node(1);
        tree.node.left.right = new Node(3);

        if (tree.checkIfBST(tree.node))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }



    //Inorder and store in array and check if array is sorted
    /*
    private boolean isSortedArray() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1)) {
				return false;
			}
		}

		return true;
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
    */
}
