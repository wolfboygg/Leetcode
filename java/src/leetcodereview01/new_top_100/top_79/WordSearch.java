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


    public static void main(String[] args) {
        char[][] charMatrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'V'}};
        String str = "ABCCEE";
        WordSearch search = new WordSearch();
        boolean isExit = search.findPath(charMatrix, str);
        System.out.println(isExit);
    }
}
