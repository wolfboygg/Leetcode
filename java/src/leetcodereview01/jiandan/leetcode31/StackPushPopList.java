package leetcodereview01.jiandan.leetcode31;

import java.util.Stack;

public class StackPushPopList {

    public boolean isPopSequence(int[] pushList, int[] popList) {
        // 通过压入和弹出实现
        int length = pushList.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < length; i++) {
              stack.push(pushList[i]);
              while(popIndex < length && !stack.isEmpty() && stack.peek() == popList[popIndex]) {
                  stack.pop();
                  popIndex++;
              }
        }
        return stack.isEmpty();
    }

    // 判断是否是弹出序列，使用栈来辅助实现
    public boolean isPopSquence01(int[] pushList, int[] popList) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(popIndex < pushList.length && !stack.isEmpty() && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSquence02(int[] pushList, int[] popList) {
        int length = pushList.length;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
              stack.push(pushList[i]);
              while(popIndex < length && !stack.isEmpty() && popList[popIndex] == stack.peek()) {
                  stack.pop();
                  popIndex++;
              }
        }
        return stack.isEmpty();
    }


    public boolean isPopSquence03(int[] pushList, int[] popList) {
        // 检测是否为弹出序列
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && popIndex < popList.length && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence04(int[] pushList, int[] popList) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && popIndex < popList.length && popList[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence05(int[] pushList, int[] popList) {
        // 就是通过一个辅助栈，来将元素不停的入栈和出栈，来判断是否为空
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : pushList) {
            stack.push(value);
            while (index < popList.length && !stack.isEmpty() && stack.peek() == popList[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence06(int[] pushList, int[] popList) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i : pushList) {
            stack.push(i);
            while(popIndex < popList.length && !stack.isEmpty() && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++; // +1处理
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence07(int[] pushList, int[] popList) {
        // 判断是否为弹出序列
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && popIndex < popList.length && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence08(int[] pushList, int[] popList) {
        // 是不是弹出顺序，还是要通过stack进行处理不停的压栈然后检查是否和popList的中的顺序相同
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && popIndex < popList.length && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public boolean isPopSequence09(int[] pushList, int[] popList) {
        // 检查是不是弹出序列还是要通过栈进行辅助检测
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && popIndex < popList.length && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    // 检查是否是栈的弹出序列 使用一个辅助栈进行实现
    public boolean isPopSequence10(int[] pushList, int[] popList) {
        if (pushList == null || popList == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while(!stack.isEmpty() && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushList = {1, 2, 3, 4, 5};
        int[] popList = {4, 5, 3, 2, 1};
        int[] popList02 = {4, 3, 5, 1, 2};
        StackPushPopList stackPushPopList = new StackPushPopList();
        System.out.println(stackPushPopList.isPopSequence10(pushList, popList));
        System.out.println(stackPushPopList.isPopSequence10(pushList, popList02));
        System.out.println(stackPushPopList.isPopSequence10(pushList, popList));
    }

    private boolean isPopSquence(int[] pushList, int[] popList) {
        Stack<Integer> stack = new Stack<>();
        int length = pushList.length;
        int popIndex = 0;
        for (int index = 0; index < length; index++) {
            stack.push(pushList[index]);
            while(popIndex < length && !stack.isEmpty() && stack.peek() == popList[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
