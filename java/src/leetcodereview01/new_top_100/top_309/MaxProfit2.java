package leetcodereview01.new_top_100.top_309;

public class MaxProfit2 {

    public int calculate(int[] price) {
        if (price == null || price.length == 0) {
            return -1;
        }
        // 使用动态规划实现，两个数组，又或者没有
        int[][] matrix = new int[price.length][2];
        matrix[0][0] = -price[0];// 表示有
        matrix[0][1] = 0;// 表示没有
        for (int i = 1; i < price.length; i++) {
            matrix[i][0] = Math.max(matrix[i - 1][0], matrix[i - 1][1] - price[i]); // 表示有
            matrix[i][1] = Math.max(matrix[i - 1][1], matrix[i - 1][0] + price[i]); // 表示没有
        }
        return matrix[price.length - 1][1];
    }

    public int calculate02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 冷冻起不能买卖
        int[][] dp = new int[arr.length][2];
        dp[0][0] = -arr[0];// 表示有
        dp[0][1] = 0;// 没有
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] - arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + arr[i], dp[i - 1][1]);
        }
        return dp[arr.length-1][1];
    }
    public int calculate03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 计算股票的最大利润
        int[][] dp = new int[arr.length][2];
        // 因为有冷静期，所以要两个数组进行处理
        dp[0][0] = -arr[0]; // 要是有
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - arr[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + arr[i]); // 表示没有
        }
        return dp[arr.length - 1][1];
    }
    // 股票的最大利润，包含冷冻期
    public int calculate04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[][] dp = new int[arr.length][2];
        // 又或者没有
        dp[0][0] = -arr[0];// 有
        dp[0][1] = 0; // 没有
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - arr[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + arr[i]);
        }
        return dp[arr.length - 1][1];
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        // 买卖股票的最大利润 很冷冻期
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int value = maxProfit2.calculate04(arr);
        System.out.println(value);
    }
}
