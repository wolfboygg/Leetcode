package leetcodereview01.new_top_100.top_72;

/**
 * 编辑距离就是将A变为B的最小方式
 */
public class EditDistance {

    public int minDistance01(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int n = str1.length();
        int m = str2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int row = dp[i - 1][j] + 1; // 必须+1才能变为下一个
                int column = dp[i][j - 1] + 1;
                int arrow = dp[i - 1][j - 1];
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    arrow = arrow + 1;
                }
                dp[i][j] = Math.min(row, Math.min(column, arrow));
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        EditDistance editDistance = new EditDistance();
        int value = editDistance.minDistance01(str1, str2);
        System.out.println(value);
    }

}
