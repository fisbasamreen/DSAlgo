package src.LinkedList;

public class SwapNodesInPairs {
    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static Node head;

    public Node swapPairs(Node head) {
        Node curr = head;
        while(curr!=null && curr.next!=null){
            Node temp = curr.next.next;

            int data = curr.next.data;
            curr.next.data = curr.data;
            curr.data = data;

            curr = temp;
        }

        return head;
    }

    void printList(Node node){
        if(node==null){
            return;
        }
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesInPairs list = new SwapNodesInPairs();

        /* Created Linked List 1->2->3->4->5 */

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        System.out.println("Linked List before calling pairWiseSwap() ");
        list.printList(list.head);

        Node list1 = list.swapPairs(list.head);

        System.out.println(" ");
        System.out.println("Linked List after calling pairWiseSwap() ");
        list.printList(list1);
    }
}
