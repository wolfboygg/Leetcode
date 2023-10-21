package leetcodereview01.jiandan.leetcode03;

import java.lang.reflect.Array;

/**
 * 数组中重复的数字
 */
public class ArrayRepeatNumber {

    /** 找到任意一个重复的即可 */
    public int findRepeatNumber03(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            while(arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }

        return -1;
    }

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
        for (int i = 0; i < array.length - 1; i++) {
            while (array[i] != i) {
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


    public int findRepeatNumber3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber04(int[] arr) {
        // 找到是否有重复的数字，就是0～n-1,把对应的数字放到对应的位置
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber05(int[] arr) {
        // 找到数组中重复的数字，就是通过将对应的数字放到对应的位置，否则就进行交换
        for (int i = 0; i < arr.length; i++) {
            while(i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[i];
                    arr[i] = arr[arr[i]];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber06(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while(i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
//                    int temp = arr[i];
//                    arr[i] = arr[temp];
//                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber07(int[] arr) {
        // 找到重复的数字就是将对应的数字放到index位置
        for (int i = 0; i < arr.length; i++) {
            while(i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    int temp = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ArrayRepeatNumber arrayRepeatNumber = new ArrayRepeatNumber();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = arrayRepeatNumber.findRepeatNumber07(arr);
        if (repeatNumber == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("找到了重复的数字，是：" + repeatNumber);
        }
    }
}
