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

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        TowSumInArray towSumInArray = new TowSumInArray();
        int[] targetValue = towSumInArray.getTargetValue(arr, 9);
        System.out.println(Arrays.toString(targetValue));
    }
}
