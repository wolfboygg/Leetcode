package leetcodereview01.new_top_100.top_128;

import java.util.*;

/**
 * 最长连续递增数组长度
 */
public class MainLengthIncrementArray {

    public int getMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 解题思路通过HashSet去重之后进行判断是否有
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 0;
        for (int item : arr) {
            if (!set.contains(item -1)) {
                int cur = item;
                int curLength = 1;
                while(set.contains(cur+1)) {
                    cur++;
                    curLength++;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }


    public int getMaxLength01(int[] arr) {
        // 最长连续递增序列 通过HashSet去重之后判断是否存在
        if (arr == null || arr.length == 0) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i]-1)) { // 防止重复计算
                int curLength = 1;
                int curValue = arr[i];
                while(set.contains(curValue+1)) {
                    curValue++;
                    curLength++;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }

    // 这里是为了找到递增的但是是没有排序的的 所以递增的幅度为1
    // 解题思路只能在set中进行查找
    public int getMaxLength02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用set去重之后处理
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int item : arr) {
            if (!set.contains(item -1)) {
                int curLength = 1;
                int num = item;
                while(set.contains(num + 1)) {
                    num++;
                    curLength++;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }

    // 无序的数组中找到递增最大字数组
    public int getMaxLength03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用一个set进行处理
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int num = arr[i];
                int curLength = 1;
                // 这里应该转接之后的值
                while(set.contains(num + 1)) {
                    num = num + 1;
                    curLength += 1;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }

    // 最长连续递增序列
    public int getMaxLength04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int currentValue = arr[i];
                int count = 1;
                while(set.contains(currentValue + 1)) {
                    currentValue += 1;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int getMaxLength05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int count = 1;
                int value = arr[i];
                while (set.contains(value + 1)) {
                    count++;
                    value += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    // 使用加法+存储的方式进行查找
    public int getMaxLength06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            // 这种操作可以少遍历
            if (!set.contains(value - 1)) {
                count++;
                while(set.contains(value + 1)) {
                    count++;
                    value = value + 1;
                }
                max = Math.max(max, count);
            }
            count = 0;
        }
        return max;
    }

    // 这种使用存储的方式进行便利查找
    public int getMaxLength07(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (!set.contains(arr[i] - 1)) {
                count++;
                int value = arr[i];
                while(set.contains(value + 1)) {
                    count++;
                    value = value + 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    // 最长连续递增子序列
    public int getMaxLength08(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int count = 0;
                int value = arr[i];
                while(set.contains(value)) {
                    count++;
                    value++;
                }
                max = Math.max(max, count);
            }
        }
        return max;

    }


    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        MainLengthIncrementArray mainLengthIncrementArray = new MainLengthIncrementArray();
        System.out.println(mainLengthIncrementArray.getMaxLength08(arr));
    }

}
