package src.LinkedList;

public class Merge2SortedLinkedList {
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

    static Node mergeLists(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node c1 = list1;
        Node c2 = list2;

        while(c1!=null && c2!=null){
            if(c1.data<c2.data) {
                curr.next = c1;
                c1 = c1.next;
            } else{
                curr.next = c2;
                c2 = c2.next;
            }

            curr = curr.next;
        }

        curr.next = c1 != null ? c1 : c2;
        return dummy.next;
    }

    static void printList(Node node){
        if(node==null){
            return;
        }
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Merge2SortedLinkedList llist1 = new Merge2SortedLinkedList();
        Merge2SortedLinkedList llist2 = new Merge2SortedLinkedList();

        llist1.head = new Node(5);
        llist1.head.next = new Node(10);
        llist1.head.next.next = new Node(15);

        llist2.head = new Node(2);
        llist2.head.next = new Node(3);
        llist2.head.next.next = new Node(20);

        mergeLists(llist1.head,llist2.head);
        printList(head);

    }
}
