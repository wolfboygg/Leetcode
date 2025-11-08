package leetcodereview01.new_top_100.top_322;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class CoinChange {


    private int calculate(int[] coins, int amount) {
        // 同样使用动态规划
        if (coins == null || coins.length == 0 || amount == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int calculate02(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) { // 等于的时候也要算 否则就错了 这里必须要等于哈
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]  + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 其实找到最小的凑钱
    public int calculate03(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 凑钱 不太会呀
    public int calculate04(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i- coins[j]]) + 1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public int calculate05(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]], dp[i]) + 1;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public int calculate06(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] >= amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.calculate06(coins, amount));
    }
}
