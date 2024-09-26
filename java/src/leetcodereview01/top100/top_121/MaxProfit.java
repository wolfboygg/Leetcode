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
    public static void main(String[] args){
      int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int max = maxProfit.maxProfit(prices);
        System.out.println(max);
    }
}
