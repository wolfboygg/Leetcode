package stacktoqueue;


import java.util.Stack;

/**
 * 用两个栈实现队列
 * 操作提供push和pop操作
 */

public class StackToQueue {

    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTow = new Stack<>();

    public void push(int value) {
        stackOne.push(value);
    }

    public int pop() throws Exception {
        if (stackTow.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTow.push(stackOne.pop());
            }
        }
        if (stackTow.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return stackTow.pop();

    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        try {
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            queue.push(6);
            queue.push(7);
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
