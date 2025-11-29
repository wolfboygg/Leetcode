package leetcodereview01.new_top_100.top_221;

/**
 * 最大的正方形
 */
public class MaxSquare {

    public int getMaxSquare(char[][] matrix) {
        // 使用动态规划的方式进行处理，判断当前为1，那么就进行增加区域的大小
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        // 进行遍历处理
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0 || i == 0) {
                        dp[i][j] = 0;
                    } else {
                        // 计算大小 这里最小就是为了构成一个正方形
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        if (max != 0) {
            max = max * max;
        }
        return max;
    }

    public int getMaxSquare01(char[][] matrix) {
        // 最大的正方形
        if (matrix == null) {
            return -1;
        }
        // 使用动态规划的方式处理
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) { // 作为左上角的位置开始
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    // 最大的正方形 需要判断那个是，所以还需要使用动态规划进行实现
    public int getMaxSquare02(char[][] matrix) {
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
                        // 一定要拿大最小的，所以要拿到对角的然后在+1
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    // 动态规划求最大的长方形
    public int getMaxSquare03(char[][] matrix) {
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
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public int getMaxSquare04(char[][] matrix) {
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
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int getMaxSquare05(char[][] matrix) {
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
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int getMaxSquare06(char[][] matrix) {
        // 计算正方形
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int getMaxSquare07(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        // 需要便利开始查找
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0) {
                       dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public int getMaxSquare08(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0) { // 这里判断没错，只要求出左下角就ok了
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max* max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaxSquare maxSquare = new MaxSquare();
        int area = maxSquare.getMaxSquare08(matrix);
        System.out.println(area);
    }
}
