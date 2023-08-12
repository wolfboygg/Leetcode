package leetcodereview01.jiandan.leetcode57_1;

import java.util.Arrays;

public class TowSumInArray {

    public int[] getTargetValue(int[] arr, int target) {
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            if (arr[P1] + arr[P2] > target) {
                P2--;
            } else if (arr[P1] + arr[P2] < target) {
                P1++;
            } else {
                return new int[]{arr[P1], arr[P2]};
            }
        }
        return new int[-1];
    }

    public int[] getTargetSum(int[] arr, int sum) {
        int[] result = new int[2];
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if (arr[left] + arr[right] > sum) {
                right--;
            } else if (arr[left] + arr[right] < sum) {
                left++;
            } else {
                result[0] = arr[left];
                result[1] = arr[right];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        TowSumInArray towSumInArray = new TowSumInArray();
        int[] targetValue = towSumInArray.getTargetSum(arr, 9);
        System.out.println(Arrays.toString(targetValue));
    }
}
