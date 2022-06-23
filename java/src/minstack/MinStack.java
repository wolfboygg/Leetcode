package minstack;

import java.util.Stack;

/**
 * 包含Min函数的栈
 * 需要一个辅助栈进行实现。存入一个值就存入最小栈中一个值，一定是最小的值，否则就是原来最小的值
 */
public class MinStack {
    private Stack<Integer> dataStack = null;
    private Stack<Integer> minStack = null;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int value) {
        dataStack.push(value);
        minStack.push(minStack.isEmpty() ? value : Math.min(minStack.peek(), value));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int min() {
        return minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public void printString() {
        System.out.println(dataStack.toString() + "---->" + minStack.toString());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        minStack.printString();
        minStack.pop();
        minStack.pop();
        minStack.push(0);
        minStack.printString();
    }
}
