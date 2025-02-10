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

    public int[] rowSum2(int[] arr, int target) {
        // 通过左右指针的方式进行
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int P1 = 0;
        int P2 = arr.length - 1;
        while(P1 < P2) {
            if (arr[P1] + arr[P2] > target) {
                P2--;
            } else if (arr[P1] + arr[P2] < target) {
                P1++;
            } else {
                return new int[] {arr[P1], arr[P2]};
            }
        }
        return new int[] {};
    }

    public int[] twoSum03(int[] arr, int target) {
        // 两数之和
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if (arr[left] + arr[right] > target) {
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                return new int[] {arr[left], arr[right]};
            }
        }
        return null;
    }

    // 当数组无序的时候
    public int[] twoSumWX03(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] {target - arr[i], arr[i]};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public int[] twoSum04(int[] arr, int target) {
        // 有序的数组直接使用双指针的方式处理
        if (arr == null || arr.length == 0) {
            return null;
        }
        int P1 = 0;
        int P2 = arr.length - 1;
        while(P1 < P2) {
            if (arr[P1] + arr[P2] > target) {
                P2--;
            } else if (arr[P1] + arr[P2]  < target) {
                P1++;
            } else {
                return new int[] {arr[P1], arr[P2]};
            }
        }
        return null;
    }

    // 当数组无序的时候需要使用hashmap的方式进行处理，判断在map中是否存在target- arr[i]
    public int[] twoSumWx04(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{target - arr[i], arr[i]};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int[] num2 = {3, 2, 4};
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        int[] result = twoNumberSum.twoSumWx04(num2, 6);
        System.out.println(Arrays.toString(result));
    }
}
