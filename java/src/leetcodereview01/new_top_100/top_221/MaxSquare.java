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


    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaxSquare maxSquare = new MaxSquare();
        int area = maxSquare.getMaxSquare(matrix);
        System.out.println(area);
    }
}
