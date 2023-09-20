package src.LinkedList;

public class ReverseLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node node;

    static Node reverse(Node node){
        Node prev = null;
        Node next = null;
        Node curr = node;

        while(curr!= null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node = prev;
        return prev;
    }

    static void printList(Node node) {
        while(node!= null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.node = new Node(10);
        list.node.next = new Node(20);
        list.node.next.next = new Node(30);
        list.node.next.next.next = new Node(40);
        list.node.next.next.next.next = new Node(50);

        printList(list.node);
        System.out.println("");
        System.out.println("After reverse");

        Node reverse = reverse(list.node);
        printList(reverse);


    }
}
