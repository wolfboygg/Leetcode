package leetcodereview01.jiandan.leetcode12;

public class MatrixPath {

    public boolean findPath02(char[][] matrix, String path) {
        char[] pathArr = path.toCharArray();
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int[][] next = new int[][]{
                {-1, 0}, // 左
                {0, -1}, // 上
                {1, 0}, // 右
                {0, 1} // 下
        };
        boolean[][] marked = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                return backTracking02(matrix, pathArr, 0, next, marked, i, j);
            }
        }
        return false;
    }

    public boolean backTracking02(char[][] matrix, char[] pathArr, int pathLength, int[][] next, boolean[][] marked, int i, int j) {
        if (pathArr.length == pathLength) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j] || matrix[i][j] != pathArr[pathLength]) {
            return false;
        }
        marked[i][j] = true;
        for (int[] ints : next) {
            if (backTracking02(matrix, pathArr, pathLength + 1, next, marked, i + ints[0], j + ints[1])) {
                return true;
            }
        }
        marked[i][j] = false;
        return false;
    }


    public boolean findPath03(char[][] matrix, String str) {
        if (str == null) {
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
                if (backTracking03(matrix, mark, next, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking03(char[][] matrix, boolean[][] mark, int[][] next, String str, int i, int j, int index) {
        if (index == str.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 ||  j >= column || mark[i][j] || matrix[i][j] != str.charAt(index)) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking03(matrix, mark, next, str, i + ints[0], j + ints[1], index + 1)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }



    // ABCE
    // SFCS
    // ADEE
    public static void main(String[] args) {
        char[][] charMatrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "SFCSF";
        MatrixPath matrixPath = new MatrixPath();
        boolean isExit = matrixPath.findPath03(charMatrix, str);
        System.out.println(isExit);
    }

    public int row = 0;
    public int column = 0;

}
