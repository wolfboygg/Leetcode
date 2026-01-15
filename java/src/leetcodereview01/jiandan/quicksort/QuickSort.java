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

    public void sortByDouble2(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 主要是找位置
        int pivotIndex = partition01(arr, start, end);
        sortByDouble2(arr, start, pivotIndex - 1);
        sortByDouble2(arr, pivotIndex + 1, end);
    }

    public int partition01(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        int left = start + 1;
        int right = end;
        while(left < right) {
            while(left < right && arr[right] > pivotValue) {
                right--;
            }
            while(left < right && arr[left] < pivotValue) {
                left++;
            }
            if (left != right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 3, 9, 2, 1, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sortByDouble2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
