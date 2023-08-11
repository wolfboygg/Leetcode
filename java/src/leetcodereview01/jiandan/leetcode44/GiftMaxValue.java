package leetcodereview01.jiandan.leetcode44;

import leetcodereview01.jiandan.leetcode04.MatrixArrayFind;

/**
 * 礼物的最大价值
 */
public class GiftMaxValue {

    public int getMaxValue(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] help = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 计算最大价值
                if (i > 0) {
                    help[i][j] = Math.max(help[i - 1][j], help[i][j]);
                }
                if (j > 0) {
                    help[i][j] = Math.max(help[i][j - 1], help[i][j]);
                }
                help[i][j] += matrix[i][j];
            }
        }
        return help[row-1][column-1];
    }

    public int getMaxValue01(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] help = new int[row][column];
        for(int i = 0; i < row; i++) {
          for (int j = 0; j < column; j++) {
              if (i > 0) {
                  help[i][j] = Math.max(help[i][j], help[i-1][j]);
              }
              if (j > 0) {
                  help[i][j] = Math.max(help[i][j], help[i][j-1]);
              }
              help[i][j] += matrix[i][j];
          }
        }
        return help[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        GiftMaxValue giftMaxValue = new GiftMaxValue();
        System.out.println(giftMaxValue.getMaxValue01(arr));;
    }

}
