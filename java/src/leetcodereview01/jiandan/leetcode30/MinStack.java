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


    public void push05(int value) {
        // 包含最小数的栈 就是要和辅助栈中的头部元素进行比较
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (value > minorStack.peek()) {
                minorStack.push(minorStack.peek());
            } else {
                minorStack.push(value);
            }
        }
    }

    public int pop05() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int min05() {
        return minorStack.peek();
    }


    // 最小栈
    public void push06(int value) {
        majorStack.push(value);
        if (majorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            if (minorStack.peek() > value) {
                minorStack.push(value);
            } else {
                minorStack.push(minorStack.peek());
            }

        }
    }

    public int pop06() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int min06() {
        return minorStack.peek();
    }


    // 最小栈 辅助处理
    public void push07(int value) {
        majorStack.push(value);
        if (minorStack.isEmpty()) {
            minorStack.push(value);
        } else {
            int tempValue = minorStack.peek();
            if (minorStack.peek() > value) {
                minorStack.push(value);
            } else {
                minorStack.push(tempValue);
            }
        }
    }


    public int pop07() {
        minorStack.pop();
        return majorStack.pop();
    }

    public int min07() {
        return minorStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push07(-2);
        minStack.push07(0);
        minStack.push07(-3);
        System.out.println(minStack.min07());
        minStack.pop07();
        System.out.println(minStack.min07());
    }
}
