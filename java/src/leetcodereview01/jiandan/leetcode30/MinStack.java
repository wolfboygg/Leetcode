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

    public void push03(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() >= value) {
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

    public int min03() {
        return minorStack.peek();
    }

    // 最小的栈 就是用另一个栈辅助实现 如果比当前值小就存小的，
    // 比当前值大就存当前值，注意如果当前栈出栈要把辅助栈也要出栈
    public void push04(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            minorStack.push(minorStack.peek() > value ? value : minorStack.peek());
        }
    }

    public int pop04() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int min04() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push04(-2);
        minStack.push04(0);
        minStack.push04(-3);
        System.out.println(minStack.min04());
        minStack.pop04();
        System.out.println(minStack.min04());
    }
}
