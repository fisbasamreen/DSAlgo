package src.Stacks;

import java.util.Stack;

public class QueueUsingStacks {
    static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }

    static void push(Stack<Integer> top_ref, int new_data)
    {
        // Push the data onto the stack
        top_ref.push(new_data);
    }

    static int pop(Stack<Integer> top_ref)
    {
        /*If stack is empty then error */
        if (top_ref.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        // pop the data from the stack
        return top_ref.pop();
    }

    static void enque(Queue q, int data) {
        push(q.stack1,data);
    }

    static int deque(Queue q) {
        int x;
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }

        if (q.stack2.isEmpty()) {
            while (!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }
        x = pop(q.stack2);
        return x;
    }

    public static void main(String args[])
    {
        /* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enque(q, 1);
        enque(q, 2);
        enque(q, 3);

        /* Dequeue items */
        System.out.print(deque(q) + " ");
        System.out.print(deque(q) + " ");
        System.out.println(deque(q) + " ");
    }

}
