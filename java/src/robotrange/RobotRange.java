package robotrange;

public class RobotRange {

    // 定义机器人的可走动的空间
    int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int threshold;
    private int rows;
    private int colums;
    private int[][] digitSum;
    private int count = 0;

    private int movingCount(int threshold, int rows, int colums) {
        this.threshold = threshold;
        this.rows = rows;
        this.colums = colums;

        initDigitSum();

        boolean[][] marked = new boolean[rows][colums];
        dfs(marked, 0, 0);

        return count;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        // 判断条件
        if (r < 0 || r >= rows || c < 0 || c >= colums || marked[r][c]) {
            return;
        }
        if (digitSum[r][c] > threshold) {
            return;
        }
        marked[r][c] = true;
        count++;
        for (int[] n : next) {
            dfs(marked, r + n[0], c + n[1]);
        }
    }

    private void initDigitSum() {
        // 计算一个矩阵中的值
        int[] digitOneSum = new int[Math.max(rows, colums)];

        for (int i = 0; i < digitOneSum.length; i++) {
            int n = i;
            while (n > 0) {
                digitOneSum[i] += n % 10;
                n = n / 10;
            }
        }
        this.digitSum = new int[rows][colums];
        // 这时候计算对应的矩阵中的值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                digitSum[i][j] = digitOneSum[i] + digitOneSum[j];
                System.out.print(digitSum[i][j] + "   ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
//        try {
            int sum = 1 / 0;
//        } catch (Exception e) {}
        RobotRange robotRange = new RobotRange();
        System.out.println(robotRange.movingCount(4, 12, 12));
    }
}
