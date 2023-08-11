package leetcodereview01.jiandan.leetcode42;

public class MaxSubArray {
    public void findSum03(int[] arr) {
        int pre = 0;
        int curSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            curSum = Math.max(curSum, pre);
        }
        System.out.println(curSum);
    }

    public void findSum04(int[] arr) {
        // 求最大子数组的和
        int pre = 0;
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]);
            maxValue = Math.max(maxValue, pre);
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 使用动态规划求解
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.findSum(arr);
        maxSubArray.findSum04(arr);
    }

    public void findSum02(int[] arr) {
        // 使用动态规划求解
        int curSum = arr[0];
        int pre = 0;
        for (int i = 0; i< arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]); // 如果加完之后还要比这个值小，那么重新开始统计
            curSum = Math.max(pre, curSum);
        }
        System.out.println(curSum);
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
