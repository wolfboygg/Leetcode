package leetcodereview01.zhongdeng.top_739;

/**
 * 每日温度
 */

import java.util.Arrays;

/**
 * 给定一个整数数组 temperatures ，
 * 表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class VeryDayTemp {
    public int[] calcuVeryTemp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        // 使用暴力进行求解
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    newArr[i] = j - i;
                    break;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] dayTemp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = {30, 60, 90};
        VeryDayTemp veryDayTemp = new VeryDayTemp();
        int[] ints = veryDayTemp.calcuVeryTemp(temperatures);
        System.out.println(Arrays.toString(ints));
    }
}
