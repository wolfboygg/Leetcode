package leetcodereview01.jiandan.leetcode12;

public class MatrixPath {

    // ABCE
    // SFCS
    // ADEE
    public static void main(String[] args) {
        char[][] charMatrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "ABCCED";
        MatrixPath matrixPath = new MatrixPath();
        boolean isExit = matrixPath.findPath01(charMatrix, str);
        System.out.println(isExit);
    }

    public int row = 0;
    public int column = 0;

    public boolean findPath01(char[][] matrix, String str) {
        // 在矩阵中进行查找，其实就是字符进行处理，然后回溯
        row = matrix.length;
        column = matrix[0].length;
        char[] pathList = str.toCharArray();
        boolean[][] marked = new boolean[row][column];
        int[][] next = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking01(matrix, pathList, marked, next, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking01(char[][] matrix, char[] pathList, boolean[][] marked, int[][] next, int pathIndex, int r, int c) {
        if (pathIndex == pathList.length) {
            return true;
        }
        if (r >= row || r < 0 || c < 0 || c >= column || matrix[r][c] != pathList[pathIndex] && marked[r][c]) {
           return false;
        }
        marked[r][c] = true;
        for (int[] ints : next) {
            if (backTracking(matrix, pathList, marked, next, pathIndex + 1, r + ints[0], c + ints[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }


    public boolean findPath(char[][] matrix, String str) {
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int r = 0;
        int c = 0;
        int[][] next = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        char[] pathList = str.toCharArray();
        boolean[][] marked = new boolean[row][column];
        for (int i = r; i < row; i++) {
            for (int j = c; j < column; j++) {
                if (backTracking(matrix, pathList, marked, next, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] matrix, char[] pathList, boolean[][] marked, int[][] next, int currPath, int r, int c) {
        if (currPath == pathList.length) {
            return true;
        }
        if (c < 0 || c >= column || r < 0 || r >= row || marked[r][c] || pathList[currPath] != matrix[r][c]) {
            return false;
        }
        marked[r][c] = true;
        for (int[] ints : next) {
            if (backTracking(matrix, pathList, marked, next, currPath + 1, r + ints[0], c + ints[1])) {
                return true;
            }

        }
        marked[r][c] = false;
        return false;
    }
}
