package examples.StackUsingQueues;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new ArrayBlockingQueue<>(100);
    private Queue<Integer> queue2 = new ArrayBlockingQueue<>(100);

    // 비어있는 큐에 먼저 값을 넣기
    public void push(int i) {
        if(queue1.isEmpty()) {
            queue1.add(i);
            while(!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
            return;
        }

        if(queue2.isEmpty()) {
            queue2.add(i);
            while(!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
        }
    }

    public int pop() {
        if(!queue1.isEmpty()) {
            return queue1.remove();
        }

        return queue2.remove();
    }

    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(1);
        stackUsingQueues.push(2);
        stackUsingQueues.push(3);
        stackUsingQueues.push(4);

        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.pop());

        stackUsingQueues.push(5);
        stackUsingQueues.push(6);

        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.pop());
        System.out.println(stackUsingQueues.pop());
    }
}
