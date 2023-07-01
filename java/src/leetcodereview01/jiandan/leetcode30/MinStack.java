package leetcodereview01.jiandan.leetcode30;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> majorStack = new Stack<>();
    private Stack<Integer> minorStack = new Stack<>();

    public void push(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            minorStack.push(minorStack.peek() > value ? value : minorStack.peek());
        }
    }

    public int pop() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int min() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
