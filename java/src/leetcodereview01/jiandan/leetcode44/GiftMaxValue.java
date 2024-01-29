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

    public int getMaxValue02(int[][] matrix) {
        // 礼物的最大价值
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] help = new int[row][column];
        for (int i = 0; i < row; i++) {
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

    // 礼物的最大价值还是通过数组进行记录
    public int getMaxValue03(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                  if (i > 0) {
                     matrix[i][j] = Math.max(matrix[i][j], matrix[i-1][j]);
                  }
                  if (j > 0) {
                      matrix[i][j] = Math.max(matrix[i][j], matrix[i][j-1]);
                  }
                  matrix[i][j] += arr[i][j];
            }
        }
        return matrix[row-1][column-1];
    }

    public int getMaxValue04(int[][] arr) {
        // 获取礼物的最大价值，通过一个辅助的二位数组进行实现
        int row = arr.length;
        int column = arr[0].length;
        int[][] help = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i > 0) help[i][j] = Math.max(help[i][j], help[i-1][j]);
                if (j > 0) help[i][j] = Math.max(help[i][j], help[i][j-1]);
                help[i][j] += arr[i][j];
            }
        }
        return help[row-1][column-1];
    }

    // 方案就是通过一个辅助的矩阵来处理，用矩阵记录当前的最大值，注意要横列都进行判断
    public int getMaxValue05(int[][] arr) {
        // 向左向右移动，那表明直接可以判断左和右那个大。那个大取那个的值
        int row = arr.length;
        int column = arr[0].length;
        int[][] help = new int[row][column]; // 记录最大的哪一个
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i > 0) help[i][j] = Math.max(help[i][j], help[i-1][j]);
                if (j > 0) help[i][j] = Math.max(help[i][j], help[i][j-1]);
                help[i][j] += arr[i][j];
            }
        }
        return help[row-1][column -1];
    }

    public int getMaxValue06(int[][] arr) {
        // 计算最大的礼物价值
        int row = arr.length;
        int column = arr[0].length;
        // 创建一个辅助的矩阵进行处理
        int[][] help = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                  if (i > 0) help[i][j] = Math.max(help[i-1][j], help[i][j]);
                  if (j > 0) help[i][j] = Math.max(help[i][j-1], help[i][j]);
                  help[i][j] += arr[i][j];
            }
        }
        return help[row-1][column-1];
    }

    // 礼物的最大价值 通过辅助的数组进行实现
    public int getMaxValue07(int[][] arr) {
        int colum = arr.length;
        int row = arr[0].length; // 列
        int[][] help = new int[colum][row];
        for (int i = 0; i < colum; i++) {
            for(int j = 0; j < row; j++) {
                if (i > 0) help[i][j] = Math.max(help[i-1][j], help[i][j]);
                if (j > 0) help[i][j] = Math.max(help[i][j-1], help[i][j]);
                help[i][j] += arr[i][j];
            }
        }
        return help[colum -1][row -1];
    }

    // 注意的是，这里需要处理和原来的数组的比较，因为都是正数，所以只要保证当前的是最大值，那么+上当前价值一定是最大值
    public int getMaxValue08(int[][] arr) {
        int column = arr.length;
        int row = arr[0].length;
        int[][] help = new int[column][row];
        for (int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
              if (i > 0) help[i][j] = Math.max(help[i-1][j], help[i][j]);
              if (j > 0) help[i][j] = Math.max(help[i][j - 1], help[i][j]);
              help[i][j] += arr[i][j];
            }
        }
        return help[column - 1][row - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        GiftMaxValue giftMaxValue = new GiftMaxValue();
        System.out.println(giftMaxValue.getMaxValue08(arr));
    }

}
