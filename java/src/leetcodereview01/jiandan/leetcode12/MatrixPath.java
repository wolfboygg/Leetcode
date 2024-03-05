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

    public boolean findPath04(char[][] matrix, String str) {
        // 排查矩阵中是否存在string
        char[] chars = str.toCharArray();
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int[][] next = {{-1, 0},{0, -1},{1, 0},{0, 1}};
        boolean[][] marked = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if (backTracking04(matrix, next, marked, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking04(char[][] matrix, int[][] next, boolean[][] marked, char[] arr, int i, int j, int index) {
        if (index == arr.length) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j] || matrix[i][j] != arr[index]) {
            return false;
        }
        marked[i][j] = true;
        for (int[] ints : next) {
            if (backTracking04(matrix, next, marked, arr, i + ints[0], j + ints[1], index + 1)) {
                return true;
            }
        }
        marked[i][j] = false;
        return false;
    }
    // 采用回溯算法进行找到 判断当前字符串是否在网格中存在
    public boolean findPath05(char[][] matrix, String str) {
        // 找到左上右下进行判断 需要matrix每一个元素都需尝试
        char[] chars = str.toCharArray();
        int[][] next = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        int row = matrix.length ;
        int column = matrix[0].length ;
        this.row = row;
        this.column = column;
        boolean[][] mark = new boolean[row][column]; // 这里有问题
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backTracking05(matrix, next, mark, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking05(char[][] matrix, int[][] next, boolean[][] mark, char[] chars, int i, int j, int index) {
        // 遍历完成也算完成
        if (chars.length == index) { // 只有等于length才能说明完成了所有的遍历
            return true;
        }
        System.out.println("i:" + i + "-->j:" + j + "-->index:" + index);
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != chars[index]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking05(matrix, next, mark, chars, i + ints[0], j + ints[1], index + 1)) {
                return true;
            }
        }
        mark[i][j] = false;
        return false;
    }

    public boolean findPath06(char[][] matrix, String str) {
        // 解题思路通过遍历所有的matrix的元素，找到路径
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int[][] next = new int[][] {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        boolean [][] mark = new boolean[row][column];
        char[] chars = str.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                  if (backTracking06(matrix, next, mark, chars, i, j, 0)) {
                      return true;
                  }
            }
        }
        return false;
    }

    private boolean backTracking06(char[][] matrix, int[][] next, boolean[][] mark, char[] chars, int i, int j, int index) {
        if (index == chars.length) {
            return true;
        }
        // 这里不能等于row，所以要排除掉。否则就有问题了。
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] != chars[index]) {
            return false;
        }
        mark[i][j] = true;
        for (int[] ints : next) {
            if (backTracking06(matrix, next, mark, chars, i + ints[0], j + ints[1], index + 1)) { // 这里会加1 因此需要等于length
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
        String str = "ABCCEE";
        MatrixPath matrixPath = new MatrixPath();
        boolean isExit = matrixPath.findPath06(charMatrix, str);
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
