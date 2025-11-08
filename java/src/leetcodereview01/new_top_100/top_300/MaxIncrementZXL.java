package leetcodereview01.new_top_100.top_300;

/**
 * 最长递增子序列
 */
public class MaxIncrementZXL {

    /**
     * 使用动态规划的方式处理
     *
     * @param arr
     * @return
     */
    public int calculate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // 最大的递增子序列
    public int calculate01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);// 就是当前的值进行+1
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }


    public int calculate02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    // 最大增长子序列
    // {10, 9, 2, 5, 3, 7, 101, 205, 18}
    public int calculate03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                   dp[i] = Math.max(dp[i], dp[j] + 1); // 已经累计到dp[i]了。
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 205, 18};
        MaxIncrementZXL maxIncrementZXL = new MaxIncrementZXL();
        System.out.println(maxIncrementZXL.calculate03(arr));
    }
}
