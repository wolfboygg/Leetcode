package leetcodereview01.zhongdeng.top_152;

import leetcodereview01.jiandan.gp.MaxProfit2;

/**
 * 乘积最大的非空连续子数组
 */
public class MaxProduct {

    public int calcu(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int preMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preMax = Math.max(arr[i], preMax * arr[i]);
            max = Math.max(max, preMax);
            System.out.println(preMax + "-->" + max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int[] arr2 = {-2, 0, -1};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.calcu(arr2));
    }
}
