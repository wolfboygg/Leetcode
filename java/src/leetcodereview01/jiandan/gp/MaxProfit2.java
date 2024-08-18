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

    public int getMaxProfit01(int[] price) {
        // 使用状态转移的方式进行处理，使用两个状态，当前这一天有或者没有
        int[][] matrix = new int[price.length][2];
        matrix[0][0] = 0;
        matrix[0][1] = -price[0];
        for (int i = 1; i < price.length; i++) {
            matrix[i][0] = Math.max(matrix[i - 1][0], matrix[i - 1][1] + price[i]); // 没有
            matrix[i][1] = Math.max(matrix[i - 1][0] - price[i], matrix[i - 1][1]);// 有
        }
        return matrix[price.length - 1][0];
    }

    /**
     * 有或者没有，一定要有一个转移的过程，比较有或者没有时候的最大值，表示当前应该有还是没有
     * @param price
     * @return
     */
    public int getMaxProfit02(int[] price) {
        // 股票的最大利润，可以多次买卖 需要使用动态规划的方式进行处理
        int[][] matrix = new int[price.length][2];
        // arr[i][0] 表示没有
        // arr[i][1] 表示有
        matrix[0][0] = 0;
        matrix[0][1] = -price[0];
        for (int i = 1; i < price.length; i++) {
            matrix[i][0] = Math.max(matrix[i - 1][0], matrix[i - 1][1] + price[i]); // 没有 //卖出
            matrix[i][1] = Math.max(matrix[i - 1][0] - price[i], matrix[i - 1][1]);
        }
        return matrix[price.length-1][0]; // 取没有的时候的价值
    }

    // 股票的最大价值
    public int getMaxProfit03(int[] price) {
        // 使用动态规划的方式
        int[][] help = new int[price.length][2];
        help[0][0] = -price[0];// 表示当前手里有股票
        for (int i = 1; i < price.length; i++) {
            help[i][0] = Math.max(help[i-1][1] - price[i], help[i-1][0]); // 表示有
            help[i][1] = Math.max(help[i-1][1], help[i][0] + price[i]); // 表示没有
            System.out.println(help[i][0] + "---" + help[i][1]);

        }
        return help[price.length-1][1];
    }


    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int value = maxProfit2.getMaxProfit03(price);
        System.out.println(value);
    }
}
