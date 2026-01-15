package leetcodereview01.new_top_100.top_48;

/**
 * 旋转图像
 */
public class RotateImage {

    // 图像顺时针旋转90度 可以考虑使用翻转进行处理
    public void rotate01(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        // 然后在对角线进行翻转一下
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate02(int[][] matrix) {
        // 旋转， 可以考虑交换
        if (matrix == null) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }

        // 交换对角线
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11},
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate02(matrix);
        // 输出结果
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
