package leetcodereview01.new_top_100.top_279;

/** 完全平方数 */
public class NumSquare {

    // 4
    public int calculate01(int n) {
        if (n <=0) {
            return -1;
        }
        int[] dp = new int[n+1];
        // 2
        for (int i = 1; i < n + 1; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquare numSquare = new NumSquare();
        System.out.println(numSquare.calculate01(2));
    }
}
