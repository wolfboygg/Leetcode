package leetcodereview01.new_top_100.top_448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，
 * 其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n]
 * 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class FindMissNumber {

    public Integer[] find(int[] arr) {
        // 找到数组中消失的数字 放到对应的位置 看哪个位置没有？？ 思路没错
        if (arr == null || arr.length == 0) {
            return new Integer[]{};
        }
        Integer[] newArr = new Integer[]{};
        for (int i = 0; i < arr.length; i++) {
            // 不停的交换
            while (arr[i] != i + 1 && arr[arr[i] - 1] != arr[i]) {
                swipe(arr, i, arr[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(i);
            }
        }

        return list.toArray(newArr);
    }

    public void swipe(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        FindMissNumber findMissNumber = new FindMissNumber();
        Integer[] nums = findMissNumber.find(arr);
        System.out.println(Arrays.toString(nums));
    }
}
