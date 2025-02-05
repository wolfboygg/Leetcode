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
            matrix[i][0] = Math.max(matrix[i-1][0], matrix[i-1][1] - price[i]); // 表示有
            matrix[i][1] = Math.max(matrix[i-1][1], matrix[i-1][0] + price[i]); // 表示没有
        }
        return matrix[price.length-1][1];
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        // 买卖股票的最大利润 很冷冻期
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int value = maxProfit2.calculate(arr);
        System.out.println(value);
    }
}
