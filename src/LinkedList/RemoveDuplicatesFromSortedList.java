package src.LinkedList;

public class RemoveDuplicatesFromSortedList {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node head;

    //New node at the front of the list
    void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    void removeDuplicates()
    {
        Node curr = head;
        while(curr!=null) {
            Node temp = curr;

            while(temp!=null && temp.data== curr.data) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();

        list.push(15);
        list.push(14);
        list.push(13);
        list.push(12);
        list.push(12);
        list.push(11);
        list.push(11);


        list.printList();

        list.removeDuplicates();

        list.printList();
    }


}
