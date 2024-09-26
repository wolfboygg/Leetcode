package leetcodereview01.new_top_100.top_01;

import java.util.Arrays;

/**
 * 两数相加
 */
public class TwoNumberSum {

    public int[] towSum(int[] arr, int target) {
        int[] result = new int[2];
        if (arr == null || arr.length == 0) {
            return result;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > target) {
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        int[] result = twoNumberSum.towSum(num, 9);
        System.out.println(Arrays.toString(result));
    }
}
