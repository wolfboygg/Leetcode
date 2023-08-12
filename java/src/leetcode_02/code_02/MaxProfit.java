package leetcode_02.code_02;

/**
 * [7,1,5,3,6,4]
 * 股票卖出一次，求最大利润
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : array) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        System.out.println(profit);
    }
}
