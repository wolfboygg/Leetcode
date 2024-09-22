package leetcodereview01.top100.top_53;

/**
 * 最大子序列的和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaxSequenceSum {

    public int findMaxSum(int[] arr) {
        // 进行遍历处理 如果遇到当前值比最大值还大，那么从这个值从新开始计算
        int max = arr[0];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(arr[i], res + arr[i]);
            max = Math.max(max, res);
        }
        return max;
    }

    public int findMaxSum01(int[] arr) {
        // 最大子序列的和
        int max = 0;
        int preMax = 0;
        for (int i = 0; i < arr.length; i++) {
            preMax = Math.max(arr[i], preMax + arr[i]);
            max = Math.max(preMax, max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSequenceSum maxSequenceSum = new MaxSequenceSum();
        int value = maxSequenceSum.findMaxSum01(arr);
        System.out.println(value);
    }
}
