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

    public static void main(String[] args) {
        int[] golds = {200, 300, 350, 400, 500};
        int[] ores = {3, 4, 3, 5, 5};
        int manNum = 10;
        MaxGold maxGold = new MaxGold();
        int result = maxGold.getGold(golds, ores, manNum);
        System.out.println(result);
    }
}
