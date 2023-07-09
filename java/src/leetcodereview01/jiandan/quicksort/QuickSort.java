package leetcodereview01.jiandan.quicksort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    public int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                if (mark != i) {
                    int temp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public void sort02(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition02(arr, startIndex, endIndex);
        sort02(arr, startIndex, pivotIndex - 1);
        sort02(arr, pivotIndex + 1, endIndex);
    }

    private int partition02(int[] arr, int startIndex, int endIndex) {
        // 双边循环
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;


    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort02(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }
}
