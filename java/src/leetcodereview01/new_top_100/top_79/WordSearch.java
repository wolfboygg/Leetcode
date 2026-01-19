package leetcodereview01.new_top_100.top_79;

import java.util.PriorityQueue;

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

    public boolean findPath04(char[][] matrix, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        this.row = matrix.length;
        this.column = matrix[0].length;
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1},
        };
        boolean[][] mark = new boolean[row][column];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking04(matrix, charArray, mark, next, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking04(char[][] matrix, char[] charArray, boolean[][] mark, int[][] next, int i, int j, int index) {
        if (index == charArray.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] != charArray[index] || mark[i][j]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking04(matrix, charArray, mark, next, i + ints[0], j + ints[1], index + 1)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    public boolean findPath05(char[][] matrix, String str) {
        if (str == null || matrix == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        boolean[][] mark = new boolean[row][column];
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0},
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking05(matrix, mark, next, i, j, charArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking05(char[][] matrix, boolean[][] mark, int[][] next, int i, int j, char[] charArr, int index) {
        if (index >= charArr.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] != charArr[index] || mark[i][j]) {
            return false;
        }

        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking05(matrix, mark, next, i+ ints[0], j+ ints[1], charArr, index + 1)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    // 单词搜索
    public boolean findPath06(char[][] matrix, String str) {
        if (matrix == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        row = matrix.length;
        column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1},
        };
        for (int i = 0; i < charArray.length; i++) {
            if (backTracking06(charArray, matrix, 0, 0, 0, mark, next)) {
                return true;
            }
        }
        return false;
    }

    public boolean backTracking06(char[] charArray, char[][] matrix, int index, int i, int j, boolean[][] mark, int[][] next) {
        if (index >= charArray.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != charArray[index]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking06(charArray, matrix,index + 1, i + ints[0], j + ints[1], mark, next)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }


    public boolean findPath07(char[][] matrix, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        this.row = matrix.length;
        this.column = matrix[0].length;
        boolean[][] mark = new boolean[row][column];
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1},
        };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking07(matrix, i, j, mark, next, charArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking07(char[][] matrix, int i, int j, boolean[][] mark, int[][] next, char[] charArr, int index) {
        if (index >= charArr.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != charArr[index]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking07(matrix, i + ints[0], j + ints[1], mark, next, charArr, index + 1)) {
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
        String str = "ABCCEDA";
        WordSearch search = new WordSearch();
        boolean isExit = search.findPath07(charMatrix, str);
        System.out.println(isExit);
    }
}
