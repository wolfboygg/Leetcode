package leetcodereview01.zhongdeng.top_198;

/**
 * 打家劫舍 不能连续拿 最大是多少
 */
public class Rob198 {

    public int rob(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        Rob198 rob198 = new Rob198();
        System.out.println(rob198.rob(arr));
    }
}
