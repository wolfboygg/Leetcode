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
    public static void main(String[] args){
        int[] arr1 = {1, 2};
        int[] arr2 = {3 ,4};

        TowSequenceArray sequenceArray = new TowSequenceArray();
        int num = sequenceArray.findMiddleNum(arr1, arr2);
        System.out.println(num);
    }
}
