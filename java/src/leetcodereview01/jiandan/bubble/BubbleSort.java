package leetcodereview01.jiandan.bubble;

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

    public void sort01(int[] arr) {
        // 冒泡排序就是一轮一轮进行比较
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isSort = true;
            for (int j = 0; j < length - i - 1; j++) {
                // 需要和后一个进行比较，要不然咋比？
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isSort = true;
            for (int j = 0; j < length - i - 1; j++) {
                // 为了和左后一个比较
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort03(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isSort = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort04(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort05(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean isSort = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort06(int[] arr) {
        // 一轮一轮进行处理
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort07(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort08(int[] arr) {
        // 冒泡排序 就是一轮一轮进行比较
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }

        }
        System.out.println(Arrays.toString(arr));
    }


    public void sort09(int[] arr) {
        // 就是多次进行循环
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort10(int[] arr) {
        // 冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort11(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void sort12(int[] arr) {
        // 冒泡排序
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void bubble13(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void bubble14(int[] arr) {
        // 冒泡排序
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble14(arr);
    }
}
