package leetcodereview01.jiandan.leetcode63;

public class MaxGP {

    public int getMaxValue(int[] arr) {
        int maxValue = 0;
        int minValue = arr[0];
        for (int item : arr) {
            minValue = Math.min(minValue, item);
            maxValue = Math.max(maxValue, item - minValue);
        }
        return maxValue;
    }

    public int getMaxValue01(int[] arr) {
        // 一次买卖，找到最小的和最大的
        int maxValue = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            maxValue = Math.max(maxValue, arr[i]- min);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        MaxGP maxGP = new MaxGP();
        System.out.println(maxGP.getMaxValue01(arr));
    }
}
