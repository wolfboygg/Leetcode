package leetcode01.repeatnumber;

import java.util.Arrays;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * [2, 3, 1, 0, 2, 5, 3]
 */
public class TestRepeatNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        Integer number = findRepeatNumber(arr);
        if (number == null) {
            System.out.println("不存在");
        } else {
            System.out.println(number);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static Integer findRepeatNumber(int[] arr) {
        // 不存在返回null,这种解决思路通过对应的下标位置放对应的数 因为数字的范围是0～n-1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                System.out.println("相同:" + i + "--->" + arr[i]);
                continue;
            } else {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println("重复");
                    return arr[i];
                } else {
                    System.out.println(i + "--->" + arr[i] + "---->" + arr[arr[i]]);
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return null;
    }
}
