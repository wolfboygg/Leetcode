package leetcodereview01.new_top_100.top_79;

import leetcodereview01.jiandan.leetcode12.MatrixPath;

/**
 * 单词搜索
 */
public class WordSearch {

    private int row = 0;
    private int column = 0;

    public boolean findPath(char[][] matrix, String str) {
        // 通过回溯的方式进行查找
        if (matrix == null || str == null) {
            return false;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int [][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        char[] charArr = str.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking(matrix, str, mark, next, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(char[][] matrix, String str, boolean[][] mark, int[][] next, int index, int i, int j) {
        if (index == str.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != str.charAt(index)) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking(matrix, str, mark, next, index+1, i + ints[0], j + ints[1])){
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    public boolean findPath01(char[][] matrix, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        // 开始进行回溯搜索
        this.row = matrix.length;
        this.column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking01(matrix, mark, next, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking01(char[][] matrix, boolean[][] mark, int[][] next, String str, int i, int j, int index) {
        if (index == str.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != str.charAt(index)) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking01(matrix, mark, next, str, i + ints[0], j + ints[1], index +1)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    // 单词搜索
    public boolean findPath02(char[][] matrix, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        row = matrix.length;
        column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking02(matrix, mark, next, i, j, 0, str)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking02(char[][] matrix, boolean[][] mark, int[][] next, int i, int j, int index, String str) {
        if (index >= str.length()) {
            return true;
        }
        System.out.println(str.charAt(index));
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != str.charAt(index)) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking02(matrix, mark, next, i + ints[0], j + ints[1], index + 1, str)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    public boolean findPath03(char[][] matrix, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int[][] next = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1},
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking03(matrix, mark, next, i, j, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking03(char[][] matrix, boolean[][] mark, int[][] next, int i, int j, int index, String str) {
        if (index >= str.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || str.charAt(index) != matrix[i][j]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking03(matrix, mark, next, i + ints[0], j + ints[1], index + 1, str)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] charMatrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'V'}};
        String str = "ABCCEVD";
        WordSearch search = new WordSearch();
        boolean isExit = search.findPath03(charMatrix, str);
        System.out.println(isExit);
    }
}
