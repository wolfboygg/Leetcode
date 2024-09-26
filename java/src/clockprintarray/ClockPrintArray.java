package clockprintarray;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * <p>
 * 定义边界值，然后进行打印即可
 */

public class ClockPrintArray {

    public static ArrayList<Integer> clockPrint(int[][] matrix) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultArray;
        }
        // 行
        int rowTop = 0;
        int rowBottom = matrix.length - 1;

        // 列
        int colLeft = 0;
        int colRight = matrix[0].length - 1;

        while (rowTop <= rowBottom && colLeft <= colRight) {
            // 上
            for (int i = colLeft; i <= colRight; i++) {
                resultArray.add(matrix[rowTop][i]);
            }
            // 右
            for (int i = rowTop + 1; i <= rowBottom; i++) {
                resultArray.add(matrix[i][colRight]);
            }

            // 下 判断行是否已经相等
            if (rowTop != rowBottom) {
                for (int i = colRight - 1; i >= colLeft; i--) {
                    resultArray.add(matrix[rowBottom][i]);
                }
            }

            if (colLeft != colRight) {
                for (int i = rowBottom - 1; i > rowTop; i--) {
                    resultArray.add(matrix[i][colLeft]);
                }
            }
            rowTop++;
            rowBottom--;
            colLeft++;
            colRight--;
        }

        return resultArray;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> integers = clockPrint(matrix);
        System.out.println(integers.toString());
    }
}
