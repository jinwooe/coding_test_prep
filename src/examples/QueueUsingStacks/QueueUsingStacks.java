package examples.QueueUsingStacks;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int i) {
        stack1.add(i);
    }

    public int dequeue() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        queueUsingStacks.enqueue(3);
        queueUsingStacks.enqueue(4);

        System.out.println(queueUsingStacks.dequeue());
        System.out.println(queueUsingStacks.dequeue());

        queueUsingStacks.enqueue(5);
        queueUsingStacks.enqueue(6);;

        System.out.println(queueUsingStacks.dequeue());
        System.out.println(queueUsingStacks.dequeue());
    }
}
