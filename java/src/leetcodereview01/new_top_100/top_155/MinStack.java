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


    public void push03(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() > value) {
                minorStack.push(value);
            } else {
                minorStack.push(minorStack.peek());
            }
        }
    }

    public int pop03() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int minValue03() {
        return minorStack.peek();
    }


    public void push04(int value) {
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            minorStack.push(minorStack.peek() < value ? minorStack.peek() : value);
        }
        majorStack.push(value);
    }

    public int pop04() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int minValue04() {
        return minorStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push04(1);
        minStack.push04(2);
        minStack.push04(3);
        minStack.push04(4);
        minStack.push04(-1);
        System.out.println(minStack.minValue04());
        minStack.pop04();
        System.out.println(minStack.minValue04());
    }
}
