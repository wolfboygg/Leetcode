package leetcodereview01.new_top_100.top_200;

import java.util.Arrays;

/**
 * 岛屿的数量
 */
public class LandNum {
    // 通过回溯的方式将所有的"1"变为0 统计一开始的个数即可
    private int row = 0;
    private int column = 0;

    public int calculateLandNum(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    backTraversal(matrix, i, j);
                }
            }
        }
        return count;
    }

    public void backTraversal(char[][] matrix, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        backTraversal(matrix, i - 1, j);
        backTraversal(matrix, i + 1, j);
        backTraversal(matrix, i, j - 1);
        backTraversal(matrix, i, j + 1);
    }

    // 计算岛屿的数量 就是通过判断1的位置来进行处理
    public int calculateLandNum01(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    backTraversal01(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void backTraversal01(char[][] matrix, int i, int j) {
        //  这里边界判断有问题
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        backTraversal01(matrix, i - 1, j);
        backTraversal01(matrix, i, j - 1);
        backTraversal01(matrix, i + 1, j);
        backTraversal01(matrix, i, j + 1);
    }

    // 岛屿的数量
    public int calculateLandNum02(char[][] matrix) {
        // 计算岛屿的数量
        if (matrix == null) {
            return -1;
        }
        // 通过回溯的方式把所有的都设置为0
        int count = 0;
        this.row = matrix.length;
        this.column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    backTraversal02(matrix, i, j);
                }
            }
        }
        return count;
    }

    public void backTraversal02(char[][] matrix, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        backTraversal02(matrix, i - 1, j);
        backTraversal02(matrix, i, j - 1);
        backTraversal02(matrix, i + 1, j);
        backTraversal02(matrix, i, j + 1);
    }

    public int calculateLandNumber03(char[][] matrix) {
        // 计算陆地的面积
        if (matrix == null) {
            return -1;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    // 处理周围的‘1’
                    backTraversal03(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public void backTraversal03(char[][] matrix, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        backTraversal03(matrix, i - 1, j);
        backTraversal03(matrix, i, j - 1);
        backTraversal03(matrix, i + 1, j);
        backTraversal03(matrix, i, j + 1);
    }

    // 回溯方法
    public int calculateLandNumber04(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        row = matrix.length;
        column = matrix[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    backTraversal04(matrix, i, j);
                }
            }
        }
        return count;
    }

    public void backTraversal04(char[][] matrix, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        backTraversal03(matrix, i - 1, j);
        backTraversal03(matrix, i, j -1);
        backTraversal03(matrix, i + 1, j);
        backTraversal03(matrix, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        LandNum landNum = new LandNum();
        System.out.println(landNum.calculateLandNumber04(grid2));
    }
}
