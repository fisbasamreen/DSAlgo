package src.LinkedList;

public class Add2Numbers {
    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static Node head1;
    static Node head2;

    Node addTwoLists(Node list1, Node list2){
        if(list1 == null || list2 == null) return list1!=null ? list1: list2;

        Node dummy = new Node(-1);
        Node res = dummy;

        int carry = 0;
        while(list1!=null || list2!=null || carry!=0) {
            int sum = carry + (list1!=null ? list1.data : 0) + (list2!=null ? list2.data : 0);

            int digit = sum%10;
            carry = sum/10;

            res.next = new Node(digit);
            res = res.next;

            if(list1!= null) {
                list1 = list1.next;
            }

            if(list2!= null) {
                list2 = list2.next;
            }

        }
        return dummy.next;
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
        Add2Numbers list = new Add2Numbers();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}
