package leetcodereview01.jiandan.leetcode03;

import java.lang.reflect.Array;

/**
 * 数组中重复的数字
 */
public class ArrayRepeatNumber {

    public int findRepeatNumber(int[] array) {
        // 通过循环，挨个进行判断，相等则重复，否则进行交换
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            while (array[i] != i) { // 需要持续交换
                int current = array[i];
                if (array[i] == array[current]) {
                    // 重复
                    return array[i];
                } else {
                    array[i] = array[current];
                    array[current] = current;
                }

            }
        }
        return -1;
    }

    public int findRepeatNumber02(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            while(array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                } else {
                    // 进行交换
                    int temp = array[i];
                    array[i] = array[temp];
                    array[temp] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayRepeatNumber arrayRepeatNumber = new ArrayRepeatNumber();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = arrayRepeatNumber.findRepeatNumber02(arr);
        if (repeatNumber == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("找到了重复的数字，是：" + repeatNumber);
        }
    }
}
