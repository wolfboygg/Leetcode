package leetcodereview01.jiandan.gp;

/**
 * 股票的最大价值 允许多次进行买卖
 */
public class MaxProfit2 {

    public int getMaxProfit(int[] price) {
        // 通过动态规划的方式进行解决，使用 状态转移的方式 这一天没有股票和这一天持有股票
        int length = price.length;
        int[][] help = new int[length][2];
        help[0][0] = 0; // 或者前一天有卖出 前一天没有
        help[0][1] = -price[0]; // 有一个
        for (int i = 1; i < length; i++) {
            help[i][0] = Math.max(help[i - 1][0], help[i - 1][1] + price[i]);
            help[i][1] = Math.max(help[i - 1][1], help[i - 1][0] - price[i]);// 前一天有或者买入
        }
        return help[length - 1][0];
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int value = maxProfit2.getMaxProfit(price);
        System.out.println(value);
    }
}
