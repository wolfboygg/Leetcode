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

    public void sortByDouble03(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // 找到分界点
        int pivotIndex = partitionByDouble03(arr, startIndex, endIndex);
        sortByDouble03(arr, startIndex, pivotIndex - 1);
        sortByDouble03(arr, pivotIndex + 1, endIndex);
    }

    private int partitionByDouble03(int[] arr, int startIndex, int endIndex) {
        // 开始进行处理
        int pivot = arr[startIndex];
        int left = startIndex + 1;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] < pivot) {
                left++;
            }
            if (left < right) {
                // 进行交换
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 更换index
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public void sortByDouble04(int[] arr, int startIndex, int endIndex) {
        // 快速排序
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partitionByDouble04(arr, startIndex, endIndex);
        System.out.println("pivot:" + pivot);
        sortByDouble04(arr, startIndex, pivot - 1);
        sortByDouble04(arr, pivot + 1, endIndex);
    }

    private int partitionByDouble04(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
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

    public void sortByDouble05(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionByDouble05(arr, startIndex, endIndex);
        sortByDouble05(arr, startIndex, pivotIndex - 1);
        sortByDouble05(arr, pivotIndex + 1, endIndex);
    }

    public int partitionByDouble05(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++; // 这里需要++ 往后走一个
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

    public void sortByDouble06(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partition06(arr, startIndex, endIndex);
        sortByDouble06(arr, startIndex, pivot - 1);
        sortByDouble06(arr, pivot + 1, endIndex);
    }

    private int partition06(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
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

    public void sortByDouble07(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partitionByDouble07(arr, startIndex, endIndex);
        sortByDouble07(arr, startIndex, pivot - 1);
        sortByDouble07(arr, pivot + 1, endIndex);
    }

    private int partitionByDouble07(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > pivot) { // 一定要从右边开始
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

    public void sortByDouble08(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partitionByDouble08(arr, startIndex, endIndex);
        sortByDouble08(arr, startIndex, pivot - 1);
        sortByDouble08(arr, pivot + 1, endIndex);
    }

    private int partitionByDouble08(int[] arr, int startIndex, int endIndex) {
        // 基本思路就是通过左右两个指针进行处理 选定一个base
        int base = arr[startIndex];
        int left = startIndex + 1;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > base) {// 右边开始
                right--;
            }
            while (left < right && arr[left] < base) {
                left++;
            }
            if (left < right) {
                // 交换
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = base;
        return left;
    }

    public void sortByDouble09(int[] arr, int start, int end) {
        // 这种排序方式还是要通过递归的方式进行排序。 主要就是通过找到一个基准的位置，记得要从后面开始处理
        if (start >= end) { // 相等也要跳出循环
            return;
        }
        int pivot = findPivotValue(arr, start, end);
        sortByDouble09(arr, start, pivot - 1);
        sortByDouble09(arr, pivot + 1, end);
    }

    public int findPivotValue(int[] arr, int start, int end) {
        // 找到基准值，默认使用第一个元素进行基准
        int pivotValue = arr[start];
        int left = start + 1; // 注意这里要舍掉start的值，要从下一个开始处理
        int right = end;
        while (left < right) {
            // 从右边开始循环
            while (left < right && arr[right] > pivotValue) {
                right--;
            }
            while (left < right && arr[left] < pivotValue) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 交换位置
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    public void sortByDouble10(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = findPivotValue10(arr, start, end);
        sortByDouble10(arr, start, pivot - 1);
        sortByDouble10(arr, pivot + 1, end);
    }

    public int findPivotValue10(int[] arr, int start, int end) {
        // 找到基准值
        int pivotValue = arr[start];
        int left = start + 1;
        int right = end;
        while (left != right) {
            // 从右边开始处理
            while (left < right && arr[right] > pivotValue) {
                right--;
            }
            while (left < right && arr[left] < pivotValue) {
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

    public void sortByDouble11(int[] arr, int start, int end) {
        // 快速排序
        if (start >= end) {
            return;
        }
        int pivotIndex = findPivot(arr, start, end);
        sortByDouble11(arr, start, pivotIndex - 1);
        sortByDouble11(arr, pivotIndex + 1, end);
    }

    public int findPivot(int[] arr, int start, int end) {
        // 选一个基准值来进行判断 交换
        int pivotValue = arr[start];
        int left = start + 1;
        int right = end;
        while (left != right) {
            while (left < right && arr[left] < pivotValue) {
                left++;
            }
            while (left < right && arr[right] > pivotValue) {
                right--;
            }
            if (left != right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 最后和start换
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    public void sortByDouble12(int[] arr, int start, int end) {
        // 快速排序
        if (start >= end) {
            return;
        }
        int pivotIndex = findPivotValue12(arr, start, end);
        sortByDouble12(arr, start, pivotIndex - 1);
        sortByDouble12(arr, pivotIndex + 1, end);
    }

    // 平均时间复杂度为nlogn 最坏为n * n
    public int findPivotValue12(int[] arr, int start, int end) {
        int left = start + 1;
        int right = end;
        int pivotValue = arr[start];
        while(left < right) {
            if (left < right && arr[right] > pivotValue) {
                right--;
            }
            if (left < right && arr[left] < pivotValue) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    public void sortByDouble13(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = findPivotIndex13(arr, start, end);
        sortByDouble13(arr, start, pivotIndex - 1);
        sortByDouble13(arr, pivotIndex + 1, end);
    }

    public int findPivotIndex13(int[] arr, int start, int end) {
        int pivotRoot = arr[start];
        int left = start + 1;
        int right = end;
        while(left < right) {
            while(left < right && arr[right] > pivotRoot) {
                right--;
            }
            while(left < right && arr[left] < pivotRoot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivotRoot;
        return left;
    }

    public void sortByDouble14(int[] arr, int left, int right) {
        // 找到对应的哨兵，然后开始左右开工
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        int pivotIndex = findPivotIndex14(arr, left, right);
        sortByDouble14(arr, left, pivotIndex - 1);
        sortByDouble14(arr, pivotIndex + 1, right);
    }

    public int findPivotIndex14(int[] arr, int left, int right) {
        int pivotValue = arr[left];
        int start = left + 1;
        int end = right;
        while(start < end) {
            if (start < end && arr[end] > pivotValue) {
                end--;
            }
            if (start < end && arr[start] < pivotValue) {
                start++;
            }
            if (start != end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        // 最后完成之后交换位置
        arr[left] = arr[start];
        arr[start] = pivotValue;
        return start;
    }


    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 3, 9, 2, 1, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sortByDouble14(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
