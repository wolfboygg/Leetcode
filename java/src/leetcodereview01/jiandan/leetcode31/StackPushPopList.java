package leetcodereview01.jiandan.leetcode31;

import java.util.Stack;

public class StackPushPopList {

    public static void main(String[] args) {
        int[] pushList = {1, 2, 3, 4, 5};
        int[] popList = {4, 5, 3, 2, 1};
        int[] popList02 = {4, 3, 5, 1, 2};
        StackPushPopList stackPushPopList = new StackPushPopList();
        System.out.println(stackPushPopList.isPopSquence(pushList, popList));
        System.out.println(stackPushPopList.isPopSquence(pushList, popList02));
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
