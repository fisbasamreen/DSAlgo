package src.LinkedList;

public class LinkedListIsPALINDROME {
    static class Node{
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

    boolean isPalindrome(Node node){
        Node slow_ptr = node;
        Node fast_ptr = node;
        Node prev_of_slow_ptr = node;
        Node midNode = null;
        boolean result = false;

        if(node!=null && node.next!=null) {
            while(slow_ptr!=null && fast_ptr!=null && fast_ptr.next!=null) {
                fast_ptr = fast_ptr.next.next;
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            if(fast_ptr!=null){
                midNode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            prev_of_slow_ptr.next = null;
            Node second_half = slow_ptr;

            second_half = reverse(second_half);

            result = compareLists(node,second_half);

            second_half = reverse(second_half);

            if(midNode!=null) {
                prev_of_slow_ptr.next = midNode;
                midNode.next = second_half;
            } else{
                prev_of_slow_ptr = second_half;
            }
        }
        return result;
    }

    boolean compareLists(Node head1, Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return false;
        }

        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return true;

        /* Will reach here when one is NULL
           and other is not */
        return false;
    }

    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        LinkedListIsPALINDROME list = new LinkedListIsPALINDROME();
        list.head = new Node('R');
        list.head.next = new Node('A');
        list.head.next.next = new Node('D');
        list.head.next.next.next = new Node('A');
        list.head.next.next.next.next = new Node('R');

        boolean result = list.isPalindrome(list.head);
        if(result) {
            System.out.println("IS A PALINDROME");
        } else{
            System.out.println("NOT A PALINDROME");
        }
    }
}
