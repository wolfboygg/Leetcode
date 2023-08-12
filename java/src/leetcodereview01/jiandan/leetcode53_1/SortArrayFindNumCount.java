package leetcodereview01.jiandan.leetcode53_1;

public class SortArrayFindNumCount {

    public void count01(int[] arr, int target) { // 升序数组
        // 统计数组中target的个数  找到左边一个右边一个 然后相减 注意左边可以=target右边要>target
        if (arr.length == 0) {
            return;
        }
        int leftIndex = binaryFind01(arr, target, true);
        int rightIndex = binaryFind01(arr, target, false) -1;
        if (leftIndex < arr.length && rightIndex < arr.length && arr[leftIndex] == target && arr[rightIndex] == target) {
            System.out.println(rightIndex - leftIndex + 1);
        }
    }

    public int binaryFind01(int[] arr, int target, boolean low) {
        // 二分查找
        int left = 0;
        int right = arr.length-1;
        int targetIndex = arr.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (arr[middle] > target || (low && arr[middle] >= target)) {
                right =  middle - 1;
                targetIndex = middle;
            } else {
                left = middle + 1;
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        SortArrayFindNumCount sortArrayFindNumCount = new SortArrayFindNumCount();
        sortArrayFindNumCount.count01(arr, 8);
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