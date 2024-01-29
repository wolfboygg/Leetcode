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
        while(left != right) {
            while(left < right && arr[right] > pivot) {
                right--;
            }
            while(left < right && arr[left] < pivot) {
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
        while(left != right) {
            while(left < right && arr[right] > pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
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
            while(left < right && arr[right] > pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
                left++; // 这里需要++ 往后走一个
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left] ;
        arr[left] = pivot;
        return left;
    }

    public void sortByDouble06(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = partition06(arr, startIndex, endIndex);
        sortByDouble06(arr, startIndex, pivot -1);
        sortByDouble06(arr, pivot + 1, endIndex);
    }

    private int partition06(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
        while(left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while(left < right && arr[left] <= pivot) {
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
        while(left != right) {
            while (left < right && arr[right] > pivot) { // 一定要从右边开始
                right--;
            }
            while(left < right && arr[left] <= pivot) {
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
        while(left != right) {
            while(left < right && arr[right] > base) {// 右边开始
                right--;
            }
            while(left < right && arr[left] < base) {
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


    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sortByDouble08(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
