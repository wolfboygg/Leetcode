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

    public void push05(int value) {
        this.preStack.push(value);
    }

    public int pop05() {
        if (!preStack.isEmpty()) {
            while(!preStack.isEmpty()) {
                postStack.push(preStack.pop());
            }
        }
        return postStack.pop();
    }

    public void push06(int value) {
        preStack.push(value);
    }

    public int pop06() {
        if (postStack.empty()) {
            while(!preStack.isEmpty()) {
                postStack.push(preStack.pop());
            }
        }
        return postStack.pop();
    }

    public boolean isEmpty06() {
        return preStack.empty() && postStack.empty();
    }


    public void push07(int value) {
        preStack.push(value);
    }

    public int pop07() {
        if (!postStack.isEmpty()) {
            return postStack.pop();
        } else {
            while(!preStack.isEmpty()) {
                postStack.push(preStack.pop());
            }
        }
        return postStack.isEmpty() ? -1 : postStack.pop();
    }

    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue = new TwoStackToQueue();
        twoStackToQueue.push07(1);
        twoStackToQueue.push07(2);
        twoStackToQueue.push07(3);
        twoStackToQueue.push07(4);
        twoStackToQueue.push07(5);
        while (!twoStackToQueue.isEmpty06()) {
            System.out.print(twoStackToQueue.pop07());
        }
    }
}
