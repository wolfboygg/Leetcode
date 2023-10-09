package leetcodereview01.jiandan.gh;

public class MaxGold {


    public int getGold(int[] golds, int[] ores, int maxNum) {
        // 列个表求解
        int[][] value = new int[golds.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    value[i][j] = value[i - 1][j];
                } else {
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - ores[i - 1]] + golds[i-1]);
                }
            }
        }
        return value[golds.length][maxNum];
    }

    public int getGold02(int[] golds, int[] ores, int manNum) {
        // 通过表格求解
        int[][] value = new int[ores.length + 1][manNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < manNum + 1; j++) {
                if (j < ores[i  - 1]) {
                    value[i][j] = value[i - 1][j];
                } else {
                    value[i][j] = Math.max(value[i - 1][j], value[i-1][j - ores[i - 1]] + golds[i -1]);
                }
            }
        }
        return value[ores.length][manNum];
    }

    public int getGold03(int[] golds, int[] ores, int maxNum) {
        // 需要构建一个表进行求解
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length +1; i++) {
            for (int j = 1; j < maxNum +1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j- ores[i-1]] + golds[i-1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold04(int[] golds, int[] ores, int maxNum) {
        // 列表 求解
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length+1; i++) {
            for (int j = 1; j < maxNum+1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold05(int[] golds, int[] ores, int manNum) {
        int[][] matrix = new int[ores.length + 1][manNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < manNum + 1; j++) {
                if (j < ores[i-1]) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j-ores[i-1]] + golds[i-1]);
                }
            }
        }
        return matrix[ores.length][manNum];
    }

    public int getGold06(int[] golds, int[] ores, int maxNum) {
        // 通过列表格进行计算
        int[][] matrix = new int[ores.length+1][maxNum+1];
        for (int i = 1; i < ores.length + 1; i++) {
              for (int j = 1; j < maxNum + 1; j++) {
                  if (j < ores[i-1]) {
                      matrix[i][j] = matrix[i-1][j];
                  } else {
                      matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j-ores[i-1]] + golds[i-1]);
                  }
              }
        }
        return matrix[ores.length][maxNum];
    }

    public static void main(String[] args) {
        int[] golds = {200, 300, 350, 400, 500};
        int[] ores = {3, 4, 3, 5, 5};
        int manNum = 10;
        MaxGold maxGold = new MaxGold();
        int result = maxGold.getGold06(golds, ores, manNum);
        System.out.println(result);
    }
}
