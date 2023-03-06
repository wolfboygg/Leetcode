package minstack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int value) {
        stack.push(value);
        min.push(min.isEmpty() ? value : Math.min(min.peek(), value));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(7);
        minStack.push(1);
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());
    }
}
