package leetcodereview01.new_top_100.top_121;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit {

    public int maxProfit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int minValue = arr[0];
        int maxValue = 0;
        for (int i : arr) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i - minValue);
        }
        return maxValue;
    }

    public int maxProfit01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int minValue = arr[0];
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]- minValue);
        }
        return maxValue;
    }

    public int maxProfit02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int minValue = arr[0];
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i] - minValue);
        }
        return maxValue;
    }

    public int maxProfit03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(arr[i] - min , max);
        }
        return max;
    }

    public int maxProfit04(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int max = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }
        return max;
    }

    public int maxProfit05(int[] arr) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int min = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        // 找到最大的利润
        MaxProfit bean = new MaxProfit();
        int i = bean.maxProfit05(arr);
        System.out.println(i);
    }

}
