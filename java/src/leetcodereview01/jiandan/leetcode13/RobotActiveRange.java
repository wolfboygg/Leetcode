package leetcodereview01.jiandan.leetcode13;

public class RobotActiveRange {

    public int row = 0;
    public int column = 0;
    public int target = 0;
    public int count = 0;

    public void findPath(int m, int n, int target) {
        this.row = m;
        this.column = n;
        this.target = target;
        count = 0;

        int[][] matrix = new int[m][n];
        int maxLength = Math.max(row, column);
        int[] value = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int temp = i;
            while ( temp > 0) {
                value[i] += (temp % 10);
                temp = temp / 10;
                System.out.println("aaa");
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value[i] + value[j];
            }
        }
        int[][] next = {
                {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        boolean[][] marked = new boolean[row][column];
        backTracking(matrix,
                next, marked, 0, 0);
        System.out.println(count);
    }

    public void backTracking(int[][] matrix, int[][] next, boolean[][] marked, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= column || marked[r][c] || matrix[r][c] > target) {
            return;
        }
        System.out.println("1111");
        marked[r][c] = true;
        count++;
        for (int[] ints : next) {
            backTracking(matrix, next, marked, r + ints[0], c + ints[1]);
        }
        marked[r][c] = false;
    }

    public void findPath01(int m, int n, int target) {
        // 其实就是一个m行n列的举证
        row = m;
        column = n;
        this.target = target;
        int maxLength = Math.max(m, n);
        int[] value = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int index = i;
            while(index > 0)   {
                value[i] += index % 10;
                index = index / 10;
            }
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value[i] + value[j];
            }
        }
        int[][] next = {
                {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        boolean[][] marked = new boolean[row][column];
        backTracking01(matrix, next, marked, 0, 0);
        System.out.println(count);
    }

    private void backTracking01(int[][] matrix, int[][] next, boolean[][] marked, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= column || matrix[r][c] > target || marked[r][c]) {
            return;
        }
        System.out.println(matrix[r][c] + "-->" + r + "--->" + c + "--->" + marked[r][c]);
        marked[r][c] = true;
        count++;
        for (int[] ints : next) {
            backTracking01(matrix, next, marked, r + ints[0], c + ints[1]);
        }
//        marked[r][c] = false;
    }

    // 机器人的活动范围，就是计算每一个位置的值，然后判断是否可以进入
    public void findPath02(int m, int n, int target) {
        // 先计算 然后在进行处理
        row = m;
        column = n;
        this.target = target;
        int max = Math.max(m, n);
        int[] value = new int[max];
        for (int i = 0; i < max; i++) {
            int index = i;
            while(index > 0) {
                value[i] += index % 10;
                index = index / 10;
            }
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value[i] + value[j];
            }
        }
        // 开始进行处理
        int[][] next = {
                {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        boolean[][] marked = new boolean[row][column];
        backTracking02(matrix, next, marked, 0, 0);
        System.out.println(count);
    }

    private void backTracking02(int[][] matrix, int[][] next, boolean[][] marked, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] > target || marked[i][j]) {
            return;
        }
        marked[i][j] = true;
        count++;
        for (int[] ints : next) {
            backTracking02(matrix, next, marked, i + ints[0], j+ ints[1]);
        }
    }

    public void findPath03(int m, int n, int target) {
        // 通过回溯的方式进行处理
        // 先计算大小
        row = m;
        column = n;
        this.target = target;
        int maxValue = Math.max(row, column);
        int[] value = new int[maxValue];
        for (int i = 0; i < maxValue; i++) {
            int temp = i;
            while(temp > 0) {
                value[i] += temp % 10;
                temp = temp / 10;
            }
        }
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                  matrix[i][j] = value[i] + value[j];
            }
        }
        boolean[][] marked = new boolean[row][column];
        int[][] next = {
                {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        backtracking03(matrix, marked, next,0, 0);
        System.out.println(count);
    }

    private void backtracking03(int[][] matrix, boolean[][] marked, int[][] next, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || matrix[i][j] > target || marked[i][j]) {
            return;
        }
        marked[i][j] = true;
        count++;
        for (int[] ints : next) {
            backtracking03(matrix, marked, next, i + ints[0], j + ints[1]);
        }
    }

    public void findPath04(int m, int n, int target) {
        // 先通过计算获得值，然后在进行处理
        row = m;
        column = n;
        this.target = target;
        int maxLength = Math.max(m, n);
        int[] value = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int temp = i;
            while(temp > 0) {
                value[i] += temp % 10;
                temp = temp / 10;
            }
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = value[i] + value[j];
            }
        }
        boolean[][] marked = new boolean[m][n];
        int[][] next = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        backtracking04(matrix, marked, next, 0, 0);
        System.out.println(count);
    }

    private void backtracking04(int[][] matrix, boolean[][] marked, int[][] next, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j] || matrix[i][j] > target) {
            return;
        }
        count++;
        marked[i][j] = true;
        for (int[] ints : next) {
            backtracking04(matrix, marked, next, i + ints[0], j + ints[1]);
        }
    }

    public void findPath05(int m, int n, int target) {
        // 还是要左右移动进行走 先算大小
        int maxValue = Math.max(m, n);
        this.target = target;
        this.row = m;
        this.column = n;
        int[] value = new int[maxValue];
        for (int i = 0; i < maxValue; i++) {
            int temp = i;
            while(temp != 0) {
                value[i] += temp % 10;
                temp = temp / 10;
            }
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                  matrix[i][j] = value[i] + value[j];
            }
        }
        int[][] next = {{-1, 0}, {0 , -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[m][n];
        backtracking05(matrix, next, marked, 0, 0);
        System.out.println(count);
    }

    private void backtracking05(int[][] matrix, int[][] next, boolean[][] marked, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j] || matrix[i][j] > target ) {
            return;
        }
        marked[i][j] = true;
        count++;
        for (int[] ints : next) {
            backtracking05(matrix, next, marked, i + ints[0], j + ints[1]);
        }
    }

    public void findPath06(int m, int n, int target) {
        // 比当前值大的不能进入，只能左右上下走
        int max = Math.max(m, n);
        int[] value = new int[max];
        this.row = m;
        this.column = n;
        for (int i = 0; i < max; i++) {
              int temp = i;
              while(temp != 0) {
                  value[i] += temp  % 10;
                  temp = temp / 10;
              }
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                  matrix[i][j] = value[i] + value[j];
            }
        }
        int[][] next = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[m][n];
        backtracking06(matrix, next, marked, 0, 0, target);
        System.out.println(count);
    }

    public void backtracking06(int[][] matrix, int[][] next, boolean[][] marked, int i, int j, int target) {
        if (i < 0 || i >= row || j < 0 || j >= column || marked[i][j] || matrix[i][j] > target) {
            return;
        }
        System.out.println("1111");
        count++;
        marked[i][j] = true;
        for (int[] ints : next) {
            backtracking06(matrix, next, marked, i + ints[0], j + ints[1], target);
        }
    }

    // 机器人的活动范围 机器人只能在到达的位置不能大于target
    public void findPath08(int m, int n, int target) {
        // 需要建立一个矩阵用来存储对应的value
        int[][] matrix = new int[m][n];
        int max = Math.max(m, n);
        int[] tempValue = new int[max];
        for (int i = 0; i < tempValue.length; i++) {
            int temp = i;
            while(temp > 0) {
                tempValue[i] += temp % 10;
                temp = temp / 10;
            }
        }
        // 填充对应的matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tempValue[i] + tempValue[j];
            }
        }

        int[][] next =  {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        this.row = m;
        this.column = n;
        boolean[][] mark = new boolean[m][n];
        backTracking08(matrix, next, mark, 0, 0, target);
        System.out.println(count);
    }

    public void backTracking08(int[][] matrix, int[][] next, boolean[][] mark, int i, int j, int target) {
        if (i < 0 || i >= row || j < 0 || j >= column || mark[i][j] || matrix[i][j] > target) {
            return;
        }
        count++;
        mark[i][j] = true;
        for (int[] ints : next) {
            backTracking08(matrix, next, mark, i+ints[0], j+ints[1], target);
        }
    }

    public static void main(String[] args) {
        RobotActiveRange robotActiveRange = new RobotActiveRange();
        robotActiveRange.findPath08(3, 2, 2);
    }
}
