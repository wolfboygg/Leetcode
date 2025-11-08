package leetcodereview01.new_top_100.top_198;

/**
 * 打家劫舍
 * 打家劫舍 不能连续拿 最大是多少
 * 说白了还是一个动态规划
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

    public int rob01(int[] arr) {
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

    public int rob02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < arr.length; i++) {
            // 不能连续拿，慢慢拿
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    public int rob03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]); // 要么拿要么不拿
        }
        return dp[arr.length - 1];
    }

    public int rob04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]); // 不能连续拿所以拿最多的
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]); // 这样就间隔好了
        }
        return dp[arr.length -1];
    }

    public int rob05(int[] arr) {
        // 不能连续进行抢劫
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        return dp[arr.length - 1];
    }

    public int rob06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], dp[0]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[arr.length - 1];
    }

    public int rob07(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 不连续拿，最大是多少，其实就是缩小范围
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Rob198 rob198 = new Rob198();
        System.out.println(rob198.rob07(arr));
    }
}
