package src.LinkedList;

public class DeleteNthNodeFromEndOfList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    //The Nth node from the end is (K-N+1)th node from the beginning.
    static Node deleteNthNodeFromEnd(Node head, int n) {
        int k = lengthOfLinkedList(head);
        Node prev = null;
        Node curr = head;

        if((k-n+1) == 1) {
            head = head.next;
            return head;
        }

        for(int i=1;i<(k-n+1);i++){
            prev = curr;
            curr = curr.next;
        }

        prev.next = prev.next.next;
        return head;

    }

    static int lengthOfLinkedList(Node head) {
        int count =0;
        if(head == null) {
            return 0;
        }
        while(head!= null) {
            head = head.next;
            count++;
        }

        return count;
    }

    static void printList(Node head) {
        while(head!=null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head =  deleteNthNodeFromEnd(head, 2);
        printList(head);
    }
}
