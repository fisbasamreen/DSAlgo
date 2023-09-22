package src.LinkedList;

public class LengthLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node node;

    static void printList(Node node) {
        while(node!= null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public int lengthLinkedList(Node node) {
        int length = 0;
        while(node!=null) {
            length++;
            node = node.next;
        }
        System.out.println("length of node " + length);
        return length;
    }

    public static void main(String[] args) {
        LengthLinkedList list = new LengthLinkedList();
        list.node = new Node(10);
        list.node.next = new Node(20);
        list.node.next.next = new Node(30);
        list.node.next.next.next = new Node(40);

        printList(list.node);
        System.out.println("");

        System.out.println(list.lengthLinkedList(list.node));


    }
}
