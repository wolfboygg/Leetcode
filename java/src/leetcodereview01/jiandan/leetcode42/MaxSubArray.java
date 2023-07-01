package leetcodereview01.jiandan.leetcode42;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 使用动态规划求解
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.findSum(arr);
    }

    private void findSum(int[] arr) {
        int pre = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            maxValue = Math.max(maxValue, pre);
        }
        System.out.println(maxValue);
    }
}
