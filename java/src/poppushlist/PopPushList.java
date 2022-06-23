package poppushlist;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 */

public class PopPushList {
    public static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        Stack<Integer> stack = new Stack<>();
        int n = pushSequence.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushOrder, popOrder));
        int[] MAP_X =
                new int[] {
                        12, 9, 18, 10, 7, 5, 4, 8, 11, 15, 19, 22, 21, 20, 16, 13, 8, 6, 2, 1, 2, 2, 4, 8, 13, 16,
                        20, 25, 24, 26, 25, 22, 17
                };
        System.out.println(MAP_X.length);
    }
}
