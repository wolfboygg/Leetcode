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

    public void sortByDouble03(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 选一个标兵，然后分为左右两个进行比较然后在进行排序
        int pivotIndex = findPivotIndex(arr, left, right);
        sortByDouble03(arr, left, pivotIndex -1);
        sortByDouble03(arr, pivotIndex + 1, right);
    }

    public int findPivotIndex(int[] arr, int left, int right) {
        // 直接选取第一个作为标兵
        int pivotValue = arr[left];
        int start = left + 1;
        int end = right;
        while(start < end) {
            while(start < end && arr[end] > pivotValue) {
                end--;
            }
            while(start < end && arr[start] < pivotValue) {
                start++;
            }
            if (start != end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        // 交换位置
        arr[left] = arr[start];
        arr[start] = pivotValue;
        return start;
    }


    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 3, 9, 2, 1, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sortByDouble03(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
