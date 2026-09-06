package leetcodereview01.new_top_100.top_42;

import java.util.Arrays;

/**
 * 接雨水
 */
public class GetRainWater {

    public int trap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 采用双指针的方式
        int left = 0;
        int right = arr.length - 1;
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        while (left < right) {
            lmax = Math.max(lmax, arr[left]);
            rmax = Math.max(rmax, arr[right]);
            System.out.println(lmax + "-->" + rmax);
            if (lmax < rmax) {
                System.out.println("left:" + (lmax - arr[left]));
                res += lmax - arr[left];
                left++;
            } else {
                System.out.println("right:" + (rmax - arr[right]));
                res += rmax - arr[right];
                right--;
            }
        }
        return res;
    }

    public int trap01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        while (left < right) {
            lmax = Math.max(lmax, arr[left]);
            rmax = Math.max(rmax, arr[right]);
            if (lmax < rmax) {
                res += lmax - arr[left];
                left++;
            } else {
                res += rmax - arr[right];
                right--;
            }
        }
        return res;
    }

    public int trap02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] leftArr = new int[arr.length];
        leftArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftArr[i] = Math.max(arr[i], leftArr[i - 1]);
        }
        int[] rightArr = new int[arr.length];
        rightArr[arr.length -1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i+1], arr[i]);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (Math.min(leftArr[i], rightArr[i]) - arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        GetRainWater getRainWater = new GetRainWater();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = getRainWater.trap02(arr);
        System.out.println(result);
    }

}
