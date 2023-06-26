package leetcodereview01.jiandan.leetcode09;

import java.util.Stack;

public class TwoStackToQueue {

    private Stack<Integer> preStack = new Stack<>();
    private Stack<Integer> postStack = new Stack<>();

    public void push(int value) {
        preStack.push(value);
    }

    public int pop() {
        while (!preStack.isEmpty()) {
            postStack.push(preStack.pop());
        }
        return postStack.pop();
    }

    public boolean isEmpty() {
        return preStack.isEmpty() && postStack.isEmpty();
    }

    public void push01(int value) {
        preStack.push(value);
    }

    public int pop01() {
        while(!preStack.isEmpty()) {
            postStack.push(preStack.pop());
        }
        return postStack.pop();
    }


    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue = new TwoStackToQueue();
        twoStackToQueue.push01(1);
        twoStackToQueue.push01(2);
        twoStackToQueue.push01(3);
        twoStackToQueue.push01(4);
        twoStackToQueue.push01(5);
        while (!twoStackToQueue.isEmpty()) {
            System.out.print(twoStackToQueue.pop01());
        }
    }
}
