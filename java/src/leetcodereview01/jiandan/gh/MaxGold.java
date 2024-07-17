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
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - ores[i - 1]] + golds[i - 1]);
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
                if (j < ores[i - 1]) {
                    value[i][j] = value[i - 1][j];
                } else {
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return value[ores.length][manNum];
    }

    public int getGold03(int[] golds, int[] ores, int maxNum) {
        // 需要构建一个表进行求解
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold04(int[] golds, int[] ores, int maxNum) {
        // 列表 求解
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold05(int[] golds, int[] ores, int manNum) {
        int[][] matrix = new int[ores.length + 1][manNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < manNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][manNum];
    }

    public int getGold06(int[] golds, int[] ores, int maxNum) {
        // 通过列表格进行计算
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold07(int[] golds, int[] ores, int maxNum) {
        // 使用动态规划进行处理，需要注意
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    // 动态规划的处理
    public int getGold08(int[] golds, int[] ores, int maxNum) {
        // 使用matrix矩阵进行处理
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }


    // 采矿动态规划
    public int getGold09(int[] golds, int[] ores, int maxNum) {
        // 使用Matrix数组进行处理
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) { // j才是人数
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    // 减去人数在取剩余人数的采矿价值  注意的一点就是j才是人数，所以要使用j去掉已经使用的人数的价值和剩余人数的价值才是最大的价值
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    public int getGold10(int[] golds, int[] ores, int maxNum) {
        // 这里使用辅助数组进行统计最终答案
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    // 所有人数 - 使用当前的人数 的最大价值 + 当前人数的最大价值  进行比较
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][maxNum];
    }

    // 黄金矿工
    public int getGold11(int[] golds, int[] ores, int manNum) {
        // 计算最大价值 需要使用一个数组进行处理
        int[][] matrix = new int[ores.length + 1][manNum + 1];
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < manNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
                }
            }
        }
        return matrix[ores.length][manNum];
    }

    // 获取最大的值
    public int getGold12(int[] golds, int[] ores, int maxNum) {
        // 怎么计算？ 就是通过动态规划
        int[][] matrix = new int[ores.length + 1][maxNum + 1];
        // 开始遍历
        for (int i = 1; i < ores.length + 1; i++) {
            for (int j = 1; j < maxNum + 1; j++) {
                if (j < ores[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - ores[i - 1]] + golds[i - 1]);
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
        int result = maxGold.getGold12(golds, ores, manNum);
        System.out.println(result);
    }
}
