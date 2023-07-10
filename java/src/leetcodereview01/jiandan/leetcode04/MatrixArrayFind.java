package leetcodereview01.jiandan.leetcode04;

public class MatrixArrayFind {

    public boolean findDestNumberExit(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int findRow = 0;
        int findColumn = column - 1;
        while (findRow < row && findColumn >= 0) {
            if (matrix[findRow][findColumn] > target) {
                findColumn--;
            } else if (matrix[findRow][findColumn] < target) {
                findRow++;
            } else {
                return true;
            }
        }

        return false;
    }


    public boolean findTargetNum(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int r = 0;
        int c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean findDestNumber2(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int r = 0;
        int c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean findTargetNumber03(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0;
        int c = column -1;
        while(r < row && c >=0) {
            if (matrix[r][c] > target) {
               c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatrixArrayFind matrixArrayFind = new MatrixArrayFind();
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean destNumberExit = matrixArrayFind.findTargetNumber03(arr, 20);
        if (destNumberExit) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

    }
}
