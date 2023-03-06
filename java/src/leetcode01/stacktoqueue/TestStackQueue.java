package leetcode01.stacktoqueue;

import stacktoqueue.StackToQueue;

import java.util.Stack;

/**
 * 两个栈实现一个队列通过栈的特性进行处理
 */
public class TestStackQueue {
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

    public static class StackToQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public void push(Integer num) {
            pushStack.push(num);
        }

        public Integer pop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            if (popStack.isEmpty()) {
                return null;
            }
            return popStack.pop();
        }

    }
}
