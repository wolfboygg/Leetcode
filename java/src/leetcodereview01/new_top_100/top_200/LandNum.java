package leetcodereview01.new_top_100.top_200;

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

    public static void main(String[] args) {
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        LandNum landNum = new LandNum();
        System.out.println(landNum.calculateLandNum(grid2));
    }
}
