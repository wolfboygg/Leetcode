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

    // 在排序的数组中进行查找就是找到左和右进行相减
    public void count02(int[] arr, int target) {
        if (arr.length == 0) {
            return;
        }
        int leftIndex = binaryFind02(arr, target, true);
        int rightIndex = binaryFind02(arr, target, false) - 1;
        if (leftIndex >= 0 && leftIndex < arr.length && rightIndex >= 0 && rightIndex < arr.length && arr[leftIndex] == target && arr[rightIndex] == target) {
            System.out.println((rightIndex - leftIndex) + 1) ;
        }
    }

    private int binaryFind02(int[] arr, int target, boolean low) {
        // 通过二分查找来处理
        int left = 0;
        int right = arr.length - 1;
        int targetIndex = -1;
        while(left <= right) { // 这里必须要相等就是要找到左和右，为了进入下一次循环middle-1
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

    // 输入: nums = [5,7,7,8,8,10], target = 8 输出: 2 在排序的数组中进行查找
    // 还是通过二分查找的方式进行处理
    public void count3(int[] arr, int target) {
        // 通过二分查找，找到左右个一个
        if (arr.length == 0) {
            return;
        }
        int leftIndex = binaryFind03(arr, target, true);
        int rightIndex = binaryFind03(arr, target, false) -1;
        if (leftIndex < arr.length && rightIndex < arr.length && leftIndex != rightIndex) {
            System.out.println(rightIndex - leftIndex + 1);
        }
    }

    public int binaryFind03(int[] arr, int target, boolean low) {
        // 二分查找
        int targetIndex = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
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

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        SortArrayFindNumCount sortArrayFindNumCount = new SortArrayFindNumCount();
        sortArrayFindNumCount.count3(arr, 8);
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