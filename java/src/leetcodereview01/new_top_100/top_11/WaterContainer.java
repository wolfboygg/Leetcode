package leetcodereview01.new_top_100.top_11;

/** 盛水的容器 */

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */
public class WaterContainer {


    public int getWaterMaxValue01(int[] arr) {
        // 解法通过遍历的方式找到value 通过左右夹击获取
        int left = 0;
        int right = arr.length - 1;
        int value = 0;
        while(left < right) {
            int temp = Math.min(arr[left], arr[right]) * (right - left);
            value = Math.max(value, temp);
            if (arr[left] <= arr[right]) { // 小的往中间走
                left++;
            } else {
                right--;
            }
        }
        return value;
    }

    public int getWaterMaxValue02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length -1;
        int max = 0;
        while(start < end) {
            int value = Math.min(arr[start], arr[end]) * (end - start);
            max = Math.max(max, value);
            if (arr[start] <= arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public int getWaterMaxValue03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int value = Math.min(arr[left], arr[right]) * (right - left);
            max = Math.max(max, value);
            if (arr[left] <= arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        WaterContainer waterContainer = new WaterContainer();
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        int value = waterContainer.getWaterMaxValue03(arr);
        System.out.println(value);
    }

}
