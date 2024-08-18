package leetcodereview01.zhongdeng.top_155;

import java.util.Stack;

/**
 * 最小的栈
 */
public class MinStack {
    /**
     * 使用两个栈进行辅助
     */
    private Stack<Integer> major = new Stack<>();
    private Stack<Integer> minor = new Stack<>();

    public void push(int value) {
        major.push(value);
        if (minor.isEmpty()) {
            minor.push(value);
        } else {
            if (minor.peek() > value) {
                minor.push(value);
            } else {
                minor.push(minor.peek());
            }
        }
    }

    public int pop() {
        minor.pop();
        return major.pop();
    }

    public int getMin() {
        return minor.peek();
    }

    public int getTop() {
        return major.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getTop());
        System.out.println(minStack.getMin());
    }
}
