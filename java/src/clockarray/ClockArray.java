package clockarray;

public class ClockArray {

    public void printlnClockArray(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }

            for (int i = top + 1; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }

            for (int i = right - 1; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                System.out.print(matrix[i][left] + " ");
            }

            System.out.println();

            top++;
            left++;
            right--;
            bottom--;
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new ClockArray().printlnClockArray(matrix);
    }
}
