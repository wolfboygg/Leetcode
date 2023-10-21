package leetcodereview01.jiandan.leetcode12;

public class MatrixPath {

    public boolean findPath02(char[][] matrix, String path) {
        char[] pathArr = path.toCharArray();
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int[][] next = new int[][] {
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
            if (backTracking02(matrix, pathArr, pathLength + 1, next, marked, i + ints[0], j+ints[1])) {
                return true;
            }
        }
        marked[i][j] = false;
        return false;
    }
    public boolean findPath03(char[][] matrix, String str) {
        // 怎么遍历就是通过挨个进行查找
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        char[] arr = str.toCharArray();
        int[][] next = {{-1, 0},{0, -1},{1, 0},{0, 1}};
        boolean[][] marked = new boolean[row][column];
        // 通过每一个元素进行遍历找到路径
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking03(matrix, arr, next, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking03(char[][] matrix, char[] arr, int[][] next, boolean[][] marked, int pathLength, int i, int j) {
        if (pathLength == arr.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >=column || marked[i][j] || matrix[i][j] != arr[pathLength]) {
            return false;
        }
        marked[i][j] = true;
        for (int[] ints : next) {
            if (backTracking03(matrix, arr, next, marked, pathLength + 1, i + ints[0], j + ints[1])) {
                return true;
            }
        }
        marked[i][j] = false;
        return false;
    }

    // ABCE
    // SFCS
    // ADEE
    public static void main(String[] args) {
        char[][] charMatrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "ABCCED";
        MatrixPath matrixPath = new MatrixPath();
        boolean isExit = matrixPath.findPath03(charMatrix, str);
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
