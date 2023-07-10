package leetcodereview01.jiandan.leetcode53_1;

public class SortArrayFindNumCount {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        SortArrayFindNumCount sortArrayFindNumCount = new SortArrayFindNumCount();
        sortArrayFindNumCount.count(arr, 8);
    }

    private void count(int[] arr, int target) {
        // 通过二分查找
        if (arr.length == 0) {
            return;
        }
        int leftIndex = binaryFind(arr, target, true);
        int rightIndex = binaryFind(arr, target, false) - 1;
        if (leftIndex < arr.length && rightIndex < arr.length && arr[leftIndex] == target && arr[rightIndex] == target) {
            System.out.println(rightIndex - leftIndex + 1);
        }
    }

    private int binaryFind(int[] arr, int target, boolean low) {
        int left = 0;
        int right = arr.length - 1;
        int targetIndex = arr.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (arr[middle] > target || (low && arr[middle] >= target)) {
                right = middle - 1;
                targetIndex = middle;
            } else {
                left = middle + 1;
            }
        }
        return targetIndex;
    }
}