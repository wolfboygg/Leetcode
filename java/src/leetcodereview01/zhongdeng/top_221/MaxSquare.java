package leetcodereview01.zhongdeng.top_221;

public class MaxSquare {

    /** 使用动态规划的方式进行求解 */
    public int getMaxSquare(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 这里必须要+1才可以哈
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        if (max != 0) {
            return max * max;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaxSquare maxSquare = new MaxSquare();
        System.out.println(maxSquare.getMaxSquare(matrix));
    }
}
