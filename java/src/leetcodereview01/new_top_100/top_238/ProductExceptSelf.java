package leetcodereview01.new_top_100.top_238;

import java.util.Arrays;

/**
 * 除去自身以为数组的乘积
 * // 这种方式正好把自己排除在外 很好，要常常联系
 */
public class ProductExceptSelf {

    public int[] product(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        right[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }

        for (int j = length - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public int[] product01(int[] arr) {
        // 除去自身之后数组的乘积
        if (arr == null || arr.length == 0) {
            return null;
        }
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }
        System.out.println(Arrays.toString(left));
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];

        }
        System.out.println(Arrays.toString(right));
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public int[] product02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] leftArr = new int[arr.length];
        leftArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = arr[i - 1] * leftArr[i - 1];
        }
        int[] rightArr = new int[arr.length];
        rightArr[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * arr[i + 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }

    public int[] product03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        // 除去自身的乘积
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        leftArr[0] = 1;
        rightArr[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = leftArr[i - 1] * arr[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * arr[i + 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }

    public int[] product04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];

        leftArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = leftArr[i-1] * arr[i-1];
        }

        rightArr[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >=0; i--) {
            rightArr[i] = rightArr[i+1] * arr[i+1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }

    // 除去自身之后的乘积
    public int[] product05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] leftArrow = new int[arr.length];
        int[] rightArrow = new int[arr.length];
        leftArrow[0] = 1;
        rightArrow[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArrow[i] = leftArrow[i-1] * arr[i-1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArrow[i] = rightArrow[i+1] * arr[i+1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftArrow[i] * rightArrow[i];
        }
        return result;
    }

    public int[] produce06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }
        // 需要两个辅助数组来实现
        int[] leftArrow = new int[arr.length];
        int[] rightArrow = new int[arr.length];
        leftArrow[0] = 1;
        rightArrow[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArrow[i] = arr[i-1] * leftArrow[i-1];
        }
        for (int i = arr.length - 2; i >=0; i--) {
            rightArrow[i] = rightArrow[i+1] * arr[i+1];
        }
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            help[i] = leftArrow[i] * rightArrow[i];
        }
        return help;
    }

    public int[] produce07(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];

        leftArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = leftArr[i-1] * arr[i-1];
        }
        rightArr[arr.length-1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i+1] * arr[i+1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }


    public static void main(String[] args) {
        // 除去自身之后的乘积
        // [1, 2, 3, 4]
        // [1, 1, 2, 6]
        // [24, 12, 4, 1]
        // [24, 12, 8, 6]
        int[] arr = {1, 2, 3, 4};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] result = productExceptSelf.produce07(arr);
        System.out.println(Arrays.toString(result));
    }
}
