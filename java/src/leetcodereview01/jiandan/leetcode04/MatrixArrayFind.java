package leetcodereview01.jiandan.leetcode04;

public class MatrixArrayFind {

    /** 按规律查找 */
    public boolean findDestNumber04(int[][] matrix, int target) {
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

    public boolean findDestNumber05(int[][] matrix, int target) {
        // 有规律的二维数组
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column -1;
        while(i < row && j >=0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber06(int[][] arr, int target) {
        int row = arr.length;
        int column = arr[0].length;
        int i = 0;
        int j = column - 1;
        while(i < row && j >=0) {
            if (arr[i][j] > target) {
               j--;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber07(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column -1;
        while(i < row && j >=0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber08(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column -1;
        while(i < row && j >=0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber09(int[][] matrix, int target) {
        // 根据矩阵的特性进行处理
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column - 1;
        while(i < row && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber10(int[][] matrix, int target) {
        // 在二维数组中进行查找
        int row = matrix.length;
        int column = matrix[0].length;
        int i = column - 1;
        int j = 0;
        while(i >= 0 && j < row) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findDestNumber11(int[][] matrix, int target) {
        int row = matrix.length -1;
        int column = matrix[0].length -1;
        int i = 0;
        int j = column - 1;
        while(i <= row && j >=0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
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
        boolean destNumberExit = matrixArrayFind.findDestNumber11(arr, 25);
        if (destNumberExit) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

    }
}
