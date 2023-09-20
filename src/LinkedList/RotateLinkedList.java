package src.LinkedList;

public class RotateLinkedList {
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

    void printList(Node node){
        if(node==null){
            return;
        }
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    Node rotate(Node head, int k) {
        if(head == null) return head;

        int count=0;
        Node curr = head;
        while(curr!=null && count<k) {
            curr = curr.next;
            count++;
        }

        if(curr == null) {
            return curr;
        }

        Node kthNode = curr;

        while (curr.next != null)
            curr = curr.next;

        curr.next = head;

        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        RotateLinkedList list = new RotateLinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        System.out.println("Given list");
        list.printList(list.head);

        Node res = list.rotate(list.head,2);

        System.out.println("");
        System.out.println("Rotated Linked List");
        list.printList(res);
    }
}
