package tantan;

public class gp {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            System.out.print(dp[i][0]);
            System.out.print("--->");
            System.out.println(dp[i][1]);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        new gp().maxProfit(price);
    }
}
