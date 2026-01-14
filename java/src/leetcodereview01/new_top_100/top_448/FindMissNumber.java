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
                list.add(i + 1);
            }
        }

        return list.toArray(newArr);
    }

    public void swipe(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // 把对应的位置的数换到index的位置
    public Integer[] find01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Integer[]{};
        }
        Integer[] newArr = new Integer[]{};
        for (int i = 0; i < arr.length; i++) {
            // 进行位置交换
            while (i + 1 != arr[i] && arr[i] != arr[arr[i] - 1]) {// 交换
                swipe01(arr, i, arr[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) { // 1-n
                list.add(i + 1);
            }
        }
        return list.toArray(newArr);
    }

    public void swipe01(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public Integer[] find02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        Integer[] newArr = new Integer[]{};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list.toArray(newArr);
    }

    // 通过交换的方式来处理没有问题
    public Integer[] find03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Integer[]{};
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]) {
                int value = arr[i];
                arr[i] = arr[value - 1];
                arr[value - 1] = value;
            }
        }
        List<Integer> list = new ArrayList<>();
        Integer[] newArr = new Integer[]{};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                list.add(i+1);
            }
        }
        return list.toArray(newArr);
    }

    public Integer[] find04(int[] arr) {
        // 注意这时的范围为1-N
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i+1 && arr[i] != arr[arr[i]-1]) {
                int temp = arr[i];
                arr[i]= arr[temp-1];
                arr[temp-1] = temp;
            }
        }
        List<Integer> list = new ArrayList<>();
        Integer[] newArr = new Integer[]{};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i+1) {
                list.add(i+1);
            }
        }
        return list.toArray(newArr);
    }

    public Integer[] find05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            while(arr[i]  != i + 1 && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  != i + 1) {
                list.add(arr[i]);
            }
        }
        return list.toArray(new Integer[list.size()]);
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        FindMissNumber findMissNumber = new FindMissNumber();
        Integer[] nums = findMissNumber.find05(arr);
        System.out.println(Arrays.toString(nums));
    }
}
