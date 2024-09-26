package pathinmatrix;

/**
 * 矩阵中是否存在一个路径，回溯法 通过一个标记数组进行处理
 */
public class PathInMatrix {

    private int rows;
    private int colums;
    private int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean hasPath(String val, int rows, int colums, String path) {
        this.rows = rows;
        this.colums = colums;
        char[] array = val.toCharArray();
        char[] pathList = path.toCharArray();
        boolean[][] marked = new boolean[rows][colums];
        char[][] matrix = buildMatrix(array, rows, colums);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (backTracking(matrix, pathList, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracking(char[][] matrix, char[] pathList, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == pathList.length) {
            return true;
        }

        if (r < 0 || r >= rows || c < 0 ||  c >= colums) {
            return false;
        } else {
            System.out.println(matrix[r][c] + " " + pathList[pathLen]);
        }

        if (r < 0 || r >= rows || c < 0 ||  c >= colums || marked[r][c] || matrix[r][c] != pathList[pathLen]) {
            return false;
        }

        marked[r][c] = true;

        for (int[] n : next) {
            if (backTracking(matrix, pathList, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }

        marked[r][c] = false;

        return false;
    }

    public char[][] buildMatrix(char[] array, int rows, int colums) {
        char[][] matrix = new char[rows][colums];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                matrix[i][j] = array[idx++];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix;
    }


    public static void main(String[] args) {
        PathInMatrix pathInMatrix = new PathInMatrix();
        String val = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String path = "ABCCSD";
        boolean res = pathInMatrix.hasPath(val, rows, cols, path);
        System.out.println(res);
    }
}
