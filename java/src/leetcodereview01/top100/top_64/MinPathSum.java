package leetcodereview01.top100.top_64;

import java.util.Arrays;

/**
 *  最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * **说明：**每次只能向下或者向右移动一步。
 */
public class MinPathSum {

    public int findMinPath(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] help = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                help[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    help[i][j] = Math.min(help[i-1][j], help[i][j]);
                }
                if (j > 0) {
                    help[i][j] = Math.min(help[i][j-1], help[i][j]);
                }
                if (help[i][j] == Integer.MAX_VALUE) help[i][j] = 0;
                help[i][j] += matrix[i][j];

                System.out.println("matrix:" + matrix[i][j] + "help:->" +help[i][j]);
            }
        }
        return help[row-1][column-1];
    }

    // 使用一个数组进行处理
    public int findMinPath01(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    matrix[i][j] += matrix[i][j-1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i-1][j];
                } else {
                    matrix[i][j] += Math.min(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        return matrix[row-1][column-1];
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        // 基本的想法就是通过一个辅助的数组进行计算，来获取最小的值
        MinPathSum minPathSum = new MinPathSum();
        int value = minPathSum.findMinPath01(matrix);
        System.out.println(value);
    }
}
