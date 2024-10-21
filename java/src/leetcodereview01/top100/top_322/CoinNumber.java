package leetcodereview01.top100.top_322;

import java.awt.print.PrinterGraphics;
import java.util.Arrays;

/** 零钱兑换 */
public class CoinNumber {

    public int getCoinNumber(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 通过动态规划的方式进行处理
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题
            int sub = getCoinNumber(coins, amount - coin);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 11 + 1 = 12
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinNumber coinNumber = new CoinNumber();
        int count = coinNumber.dp(coins, amount);
        System.out.println(count);
    }
}
