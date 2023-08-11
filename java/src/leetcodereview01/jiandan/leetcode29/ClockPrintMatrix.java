package leetcodereview01.jiandan.leetcode29;

import clockarray.ClockArray;

import java.util.ArrayList;
import java.util.List;

public class ClockPrintMatrix {

    public List printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = column - 1;
        int bottom = row - 1;

        List<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // 上
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 右
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 下 必须进行判断，可能是就一行了
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            // 左
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return list;
    }

    public List<Integer> printMatrix02(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int top = 0;
        int left = 0;
        int bottom = row - 1;
        int right = column - 1;
        while (top <= bottom && left <= right) {
            // 上
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 右
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 下
            if (top != bottom) { // top == bottom 相等时就是奇数行
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            // 左
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return list;
    }

    public List<Integer> printMatrix03(int[][] matrix) {
        // 写好左右上下进行处理，注意判断边界调节 top== bottom left == right 防止是奇数行
        int row = matrix.length;
        int column = matrix[0].length;

        int left = 0;
        int right = column -1;
        int top = 0;
        int bottom = row -1;
        List<Integer> list = new ArrayList<>();
        while(top <= bottom && left <= right) {
            // top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 右
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 下
            if (top != bottom) {
                for (int i = right -1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            // 左
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            right--;
            left++;
            bottom--;
        }
       return list;
    }

    public List<Integer> printMatrix04(int[][] matrix) {
        // 顺时针打印
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int right = column;
        int bottom = row;
        List<Integer> list = new ArrayList<>();
        while(left <= right && top <= bottom) {
            // 上
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 右
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 下
            if (top != bottom) {
                for (int i = right -1; i >= left;i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            // 左
            if (left != right) {
                for(int i = bottom - 1; i > top; i--) {
                  list.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
       return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
//                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        ClockPrintMatrix clockPrintMatrix = new ClockPrintMatrix();
        System.out.println(clockPrintMatrix.printMatrix04(matrix));
    }
}
