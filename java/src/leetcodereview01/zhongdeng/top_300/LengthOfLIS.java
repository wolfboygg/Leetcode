package leetcodereview01.zhongdeng.top_300;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * 简单的使用hashmap
     */
    public int lengthOfLIS(int[] nums) {
        // 遍历，和前面的相比较 大的就+1
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS lis = new LengthOfLIS();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
                   //[1, 1, 1, 2, 2, 3, 4, ]
        System.out.println(lis.lengthOfLIS(arr));
        ;
    }
}
