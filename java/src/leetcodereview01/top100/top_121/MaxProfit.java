package leetcodereview01.top100.top_121;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int minItem = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minItem = Math.min(minItem, prices[i]);
            maxValue = Math.max(maxValue, prices[i] - minItem);
        }
        return maxValue;
    }

    public int maxProfit01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int minPrice = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            max = Math.max(max, arr[i] - minPrice);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        int max = maxProfit.maxProfit01(prices);
        System.out.println(max);
    }
}
