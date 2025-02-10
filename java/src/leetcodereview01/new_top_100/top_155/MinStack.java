package leetcodereview01.new_top_100.top_155;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> majorStack = new Stack<>();
    private Stack<Integer> minorStack = new Stack<>();

    public void push(int value) {
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() > value) {
                minorStack.push(value);
            } else {
                minorStack.push(minorStack.peek());
            }
        }
        majorStack.push(value);
    }

    public int pop() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int minValue() {
        return minorStack.peek();
    }

    public void push01(int value) {
        majorStack.push(value);
        if (!minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() > value) {
                minorStack.push(value);
            } else {
                minorStack.push(minorStack.peek());
            }
        }
    }

    public int pop01() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int minValue01() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(-1);
        System.out.println(minStack.minValue01());
        minStack.pop01();
        System.out.println(minStack.minValue01());
    }
}
