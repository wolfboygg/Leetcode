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


    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10}; // 6
        int target = 8;
        ArrayFindIndex arrayFindIndex = new ArrayFindIndex();
        int[] result = arrayFindIndex.find(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
