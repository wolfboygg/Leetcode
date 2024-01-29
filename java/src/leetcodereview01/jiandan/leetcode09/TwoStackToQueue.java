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

    public void push02(int value) {
        preStack.push(value);
    }

    public int pop02() {
        if (postStack.isEmpty()) {
            while(!preStack.isEmpty()) {
                postStack.push(preStack.pop());
            }
        }
        return postStack.pop();
    }

    public void push03(int value) {
        preStack.push(value);
    }

    public int pop03() {
        if (postStack.isEmpty()) {
            while(!preStack.isEmpty()) {
                postStack.push(preStack.pop());
            }
        }
        return postStack.pop();
    }

    public void push04(int value) {
        preStack.push(value);
    }

    public int pop04() {
        while(!preStack.isEmpty()) {
            postStack.push(preStack.pop());
        }
        return postStack.pop();
    }


    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue = new TwoStackToQueue();
        twoStackToQueue.push04(1);
        twoStackToQueue.push04(2);
        twoStackToQueue.push04(3);
        twoStackToQueue.push04(4);
        twoStackToQueue.push04(5);
        while (!twoStackToQueue.isEmpty()) {
            System.out.print(twoStackToQueue.pop04());
        }
    }
}
