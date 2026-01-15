package leetcodereview01.new_top_100.top_64;

import java.util.Arrays;

/**
 * 最小路径和
 */
public class MinPathSum {

    public int findPath(int[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j]);
                }
                // 现将所有的辅助的设置为0
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath01(int[][] matrix) {
        // 同样是动态规划的路子
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE; // 必须先设置为最大，因为要+为最小
                if (i > 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
                if (j > 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath02(int[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        // 使用最小的辅助数组
        int row =matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath03(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath04(int[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath05(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public int findPath06(int[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i][j]);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
                dp[i][j] += matrix[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        MinPathSum minPathSum = new MinPathSum();
        int value = minPathSum.findPath05(matrix);
        System.out.println(value);
    }

}
