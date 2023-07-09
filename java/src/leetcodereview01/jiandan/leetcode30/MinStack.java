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

    public void push02(int value) {
        majorStack.push(value);
        if (!minorStack.isEmpty()) {
            minorStack.push(minorStack.peek() > value ? value : minorStack.peek());
        } else {
            minorStack.push(value);
        }
    }

    public void pop02() {
        majorStack.pop();
        minorStack.pop();
    }

    public int min02() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push02(-2);
        minStack.push02(0);
        minStack.push02(-3);
        System.out.println(minStack.min02());
        minStack.pop02();
        System.out.println(minStack.min02());
    }
}
