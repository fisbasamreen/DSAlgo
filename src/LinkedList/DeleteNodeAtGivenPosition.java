package src.LinkedList;

public class DeleteNodeAtGivenPosition {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

    static void deleteNodeAtPosition(Node node, int position) {
        if(node == null) {
            return;
        }

        Node curr = node;
        if(position == 0) {
            head = curr.next;
            return;
        }
        Node prev = null;
        for(int i=0; curr != null && i<position-1;i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }

    void printList(Node node) {
        while(node!= null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeAtGivenPosition llist = new DeleteNodeAtGivenPosition();
        llist.head = new Node(10);
        llist.head.next = new Node(20);
        llist.head.next.next = new Node(30);
        llist.head.next.next.next = new Node(40);
        llist.head.next.next.next.next = new Node(50);

        System.out.println("\nCreated Linked list is: ");
        llist.printList(llist.head);

        deleteNodeAtPosition(llist.head,4);

        System.out.println("\nAfter deleting Linked list is: ");
        llist.printList(llist.head);



    }
}
