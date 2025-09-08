package leetcodereview01.top100.top_04;

import java.util.Arrays;

/**
 * 两个有序列表求中位数
 * 简单求解，通过合并数组的方式，算法不优
 */
public class TowSequenceArray {

    public int findMiddleNum(int[] arr1, int[] arr2) {
        // 对两个数组进行合并然后再求
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < arr1.length ? arr1[i] : arr2[i - arr1.length];
        }
        System.out.println(Arrays.toString(arr));
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    // 求两个数组的中位数 首先要合并数组 排序之后进行求解
    public int findMiddleNum01(int[] arr1, int[] arr2) {
        // 合并
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < arr1.length ? arr1[i] : arr2[i - arr1.length];
        }
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            // 0 1 2 3 4 5
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    /** 求解两个数组的中位数 使用数组合并的方式进行处理 */
    public int findMiddleNum02(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return -1;
        }
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i >= arr1.length ? arr2[i-arr1.length] : arr1[i];
        }
        int middleValue = arr.length / 2;
        int result = arr.length %2 == 0 ? (arr[middleValue-1] + arr[middleValue]) /2 : arr[middleValue];
        return result;
    }

    public int findMiddleNum03(int[] arr1, int[] arr2) {
        // 通过合并数组之后进行
        int[] arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i >= arr1.length ? arr2[i- arr1.length] : arr1[i];
        }
        return arr.length % 2 == 0? arr[arr.length / 2 - 1] + arr[arr.length / 2] / 2 : arr[arr.length /2];
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2};
        int[] arr2 = {3 ,4, 5};

        TowSequenceArray sequenceArray = new TowSequenceArray();
        int num = sequenceArray.findMiddleNum03(arr1, arr2);
        System.out.println(num);
    }
}
