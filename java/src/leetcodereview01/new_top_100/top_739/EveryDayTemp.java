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
            while (!stack.isEmpty() && temperature > arr[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }

    // 使用单调栈来处理，或者不会的时候就暴力破解 遍历就完了
    public int[] getEveryDayTempByStack01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int temperature = arr[i];
            while (!stack.isEmpty() && temperature > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] getEveryDayTempByStack02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int temperature = arr[i];
            while (!stack.isEmpty() && temperature > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    // 通过栈的方式进行处理 单调栈 记录当前的index，如果找到大的要while一下
    public int[] getEveryDayTempByStack03(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] getEveryDayTempByStack04(int[] arr) {
        // 使用栈进行处理
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }
        int[] value = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                value[index] = i - index;
            }
            stack.push(i);
        }
        return value;
    }

    public int[] getEveryDayTempByStack05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] value = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                value[index] = i - index;
            }
            stack.push(i);
        }
        return value;
    }

    public static void main(String[] args) {
        // 每日温度 没高度
        int[] temperatures = {80, 74, 75, 71, 69, 72, 76, 73};
        EveryDayTemp everyDayTemp = new EveryDayTemp();
        int[] tempArr = everyDayTemp.getEveryDayTempByStack05(temperatures);
        if (tempArr == null) {
            System.out.println("null");
        } else {
            System.out.println(Arrays.toString(tempArr));
        }
    }
}
