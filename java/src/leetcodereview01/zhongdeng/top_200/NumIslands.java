package leetcodereview01.zhongdeng.top_200;

/**
 * 岛屿的数量
 */
public class NumIslands {
    private int row = 0;
    private int column = 0;

    public int calcu(char[][] matrix) {
        // 通过递归的方式进行遍历
        int row = matrix.length;
        int column = matrix[0].length;
        this.row = row;
        this.column = column;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] matrix, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] == '0') {
            return;
        }
        matrix[i][j] = '0';
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j + 1);
    }


    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.calcu(grid2));
        ;
    }
}
