package leetcodereview01.jiandan.bubble;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] arr) {
        // 冒泡排序
        for (int i = 0; i <= arr.length - 1; i++) {
            boolean isSort = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 从小到大 // 最后一个不要了
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void bubble01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    isSort = false;
                    int temp= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble01(arr);
    }
}
