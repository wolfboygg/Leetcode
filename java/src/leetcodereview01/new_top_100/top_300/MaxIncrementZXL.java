package leetcodereview01.new_top_100.top_300;

/**
 * 最长递增子序列
 */
public class MaxIncrementZXL {

    /**
     * 使用动态规划的方式处理
     * @param arr
     * @return
     */
    public int calculate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int[] dp = new int[arr.length];
        dp[0] =1;
        // 2, 5, 3, 7, 101
        // 1, 2, 2, 3, 4
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        MaxIncrementZXL maxIncrementZXL = new MaxIncrementZXL();
        System.out.println(maxIncrementZXL.calculate(arr));
    }
}
