package leetcodereview01.zhongdeng.top_238;

import review.Test;

import java.util.Arrays;

/**
 * 除去自身之外数组的乘积
 */
public class ProductExceptSelf {


    public int[] calcuResult(int[] arr) {
        // 通过左右数组的方式进行计算结果
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 1;
        right[arr.length - 1] = 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }
        System.out.println(Arrays.toString(left));

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }
        System.out.println(Arrays.toString(right));
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4}; // [ 24 ,12 ,8,6]
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.calcuResult(arr)));
    }
}
