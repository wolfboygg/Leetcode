package leetcodereview01.new_top_100.top_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 */
public class TwoNumberSum {

    // 这种方式需要排序之后才可以哈
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

    // 这种解法不行，需要的是有序的数组，但是这里的数组不一定有序
    public int[] twoSum01(int[] arr, int target) {
        // 在数组中是否能找到两个数的和是target的
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        // 使用hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int[] num2 = {3, 2, 4};
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        int[] result = twoNumberSum.twoSum01(num, 9);
        System.out.println(Arrays.toString(result));
    }
}
