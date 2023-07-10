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

    public static void main(String[] args) {
        RobotActiveRange robotActiveRange = new RobotActiveRange();
        robotActiveRange.findPath(3, 1, 0);
    }
}
