package leetcodereview01.new_top_100.top_96;

public class DifferentSearchTree {

    public int calculate01(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public int calculate02(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    // 看看能组成多少搜索二叉树
    public int calculate03(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j-1] * dp[i-j]; // 这里是相加
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DifferentSearchTree differentSearchTree = new DifferentSearchTree();
        int n = 3;
        int value = differentSearchTree.calculate01(n);
        System.out.println(value);
    }
}
