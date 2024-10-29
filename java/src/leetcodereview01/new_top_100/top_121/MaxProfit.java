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

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        // 找到最大的利润
        MaxProfit bean = new MaxProfit();
        int i = bean.maxProfit(arr);
        System.out.println(i);
    }

}
