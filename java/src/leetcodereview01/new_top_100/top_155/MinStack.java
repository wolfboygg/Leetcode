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

    public void push02(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() < value) {
                minorStack.push(minorStack.peek());
            } else {
                minorStack.push(value);
            }
        }
    }

    public int pop02() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int minValue02() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push02(1);
        minStack.push02(2);
        minStack.push02(3);
        minStack.push02(4);
        minStack.push02(-1);
        System.out.println(minStack.minValue02());
        minStack.pop02();
        System.out.println(minStack.minValue02());
    }
}
