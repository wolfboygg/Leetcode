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

    public int calculate01(int[] arr) {
        // 2 3 4
        // i = 1
        // 1, 2,
        // 最大递增子序列
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 记录当前的值
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 最大的递增子序列
    public int calculate02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
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

    // 递增子序列
    public int calculate03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        // 10, 9, 2, 5, 3, 7, 101, 1
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    // 最大递增子序列
    public int calculate04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        // 双重for循环
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) { // 主要是计算i的结果，所以第二层不能等于i
                // arr[j] + 1
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int calculate05(int[] arr) {
        // 最长递增子序列
        if (arr ==  null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1; // 这里一定是1，包含自己
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 这里是要小于
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 205, 18};
        MaxIncrementZXL maxIncrementZXL = new MaxIncrementZXL();
        System.out.println(maxIncrementZXL.calculate05(arr));
    }
}
