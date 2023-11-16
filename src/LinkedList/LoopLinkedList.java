package src.LinkedList;

public class LoopLinkedList {
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

    void detectAndRemoveLoop(Node node) {
        Node slow_ptr=head, fast_ptr=head;
        while(slow_ptr!=null && fast_ptr!=null && fast_ptr.next!=null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr==fast_ptr){
                System.out.println("Loop found");
                break;
            }
        }

        if(slow_ptr == fast_ptr){
            slow_ptr = node;
            while(slow_ptr.next!=fast_ptr.next){
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next;
            }
            fast_ptr.next = null;
        }
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
        LoopLinkedList list = new LoopLinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        list.detectAndRemoveLoop(head);
        System.out.println(
                "Linked List after removing loop : ");
        list.printList(head);
    }
}
