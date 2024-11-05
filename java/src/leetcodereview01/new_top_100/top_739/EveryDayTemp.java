package leetcodereview01.new_top_100.top_739;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 每日温度
 * 给定一个数组，找到下一次比自己高的是第几个
 */
public class EveryDayTemp {


    public int[] getEveryDayTemp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 直接遍历就行了呗
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (arr[j] > arr[i]) {
                    temp[i] = count;
                    System.out.println(arr[j] + "-->" + arr[i] + "---->" + count);
                    break;
                }
            }
        }
        return temp;
    }

    /**
     * 使用栈的方式进行实现
     */
    public int[] getEveryDayTempByStack(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int temperature = arr[i];
            while(!stack.isEmpty() && temperature > arr[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 每日温度 没高度
        int[] temperatures = {80, 74, 75, 71, 69, 72, 76, 73};
        EveryDayTemp everyDayTemp = new EveryDayTemp();
        int[] tempArr = everyDayTemp.getEveryDayTempByStack(temperatures);
        if (tempArr == null) {
            System.out.println("null");
        } else {
            System.out.println(Arrays.toString(tempArr));
        }
    }
}
