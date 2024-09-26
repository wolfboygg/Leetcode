package FindNumInEWArray;

/**
 * 查找一个数是否存在于一个二维数组中。，其每一行从左到右递增排序，从上到下也是递增排序
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * <p>
 * 解题思路:从最后一列开始查找，那么大的一定在下一行，小的数一定在左边
 */


public class FindNumInEWArray {

    public static boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int r = 0;
        int c = columns - 1;

        while (r <= rows - 1 && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean isExit = find(20, matrix);
        System.out.println("find 20 in array is:" + isExit);

        isExit = find(5, matrix);
        System.out.println("find 5 in array is:" + isExit);
    }
}