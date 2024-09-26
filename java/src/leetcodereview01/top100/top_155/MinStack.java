package leetcodereview01.top100.top_155;

import java.util.Stack;

/**
 * 实现一个最小栈
 * 使用一个辅助栈进行实现
 */
public class MinStack {
    Stack<Integer> major = new Stack<>();
    Stack<Integer> minor = new Stack<>();


    public void push(int value) {
        major.push(value);
        if (minor.isEmpty()) {
            minor.push(value);
        } else {
            minor.push(minor.peek() > value ? value : minor.peek());
        }
    }

    public int pop() {
        minor.pop();
        return major.pop();
    }

    public int min() {
        return minor.peek();
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

}
