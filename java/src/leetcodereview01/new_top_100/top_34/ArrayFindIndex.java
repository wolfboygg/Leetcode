package leetcodereview01.new_top_100.top_34;

import java.util.Arrays;

/**
 * 数组中查找到target的index
 */
public class ArrayFindIndex {

    public int[] find(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }
        int left = realFind(arr, target, true);
        int right = realFind(arr, target, false) - 1;
        System.out.println(left + "-->" + right);
        return new int[]{left, right};
    }

    public int realFind(int[] arr, int target, boolean isLow) {
        int start = 0;
        int end = arr.length - 1;
        int targetIndex = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > target || (isLow && arr[middle] >= target)) {
                end = middle - 1;
                targetIndex = middle;
            } else {
                start = middle + 1;
            }
        }
        return targetIndex;
    }

    public int[] find01(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1};
        }
        int leftIndex = realFind01(arr, target, true);
        int rightIndex = realFind01(arr, target, false) -1;
        return new int[] {leftIndex, rightIndex};
    }

    public int realFind01(int[] arr, int target, boolean isLow) {
        int low = 0;
        int height = arr.length - 1;
        int targetIndex = -1;
        while(low <= height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] > target || arr[middle] >= target && isLow) {
                height = middle - 1;
                targetIndex = middle;
            } else {
                low = middle + 1;
            }
            System.out.println(low + "--->" + height);
        }
        return targetIndex;
    }

    public int[] find02(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }
        int leftIndex = realFind02(arr, target, true);
        int rightIndex = realFind02(arr, target, false) - 1;
        return new int[] {leftIndex, rightIndex};
    }

    public int realFind02(int[] arr, int target, boolean isLow) {
        int left = 0;
        int right = arr.length - 1;
        int targetIndex = 0;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] > target || (isLow && arr[middle] >= target)) {
                right = middle - 1; //  比目标值打，right要变小
                targetIndex = middle;
            } else {
                left = middle + 1;
            }
            System.out.println("11111:" + left + "--->" + right);
        }
        return targetIndex;
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10}; // 6
        int target = 8;
        ArrayFindIndex arrayFindIndex = new ArrayFindIndex();
        int[] result = arrayFindIndex.find02(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
