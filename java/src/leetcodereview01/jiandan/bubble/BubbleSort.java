package leetcodereview01.jiandan.bubble;

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


    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
    }
}
