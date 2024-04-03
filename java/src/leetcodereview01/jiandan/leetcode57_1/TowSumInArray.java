package leetcodereview01.jiandan.leetcode57_1;

import java.util.Arrays;

public class TowSumInArray {

    public int[] getTargetValue(int[] arr, int target) {
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
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
        while (left < right) {
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

    public int[] getTargetSum01(int[] arr, int target) {
        //这种就是直接左右指针干
        int P1 = 0;
        int P2 = arr.length - 1;
        int[] result = new int[2];
        while (P1 < P2) {
            if (arr[P1] + arr[P2] > target) {
                P2--;
            } else if (arr[P1] + arr[P2] < target) {
                P1++;
            } else {
                result[0] = arr[P1];
                result[1] = arr[P2];
                break;
            }
        }
        return result;
    }

    // 通过左右指针进行处理，如果和大则进行右边移动，否则左边移动
    public int[] getTargetSum02(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while (leftPointer < rightPointer) {
            if (arr[leftPointer] + arr[rightPointer] > target) {
                rightPointer--;
            } else if (arr[leftPointer] + arr[rightPointer] < target) {
                leftPointer++;
            } else {
                return new int[]{arr[leftPointer], arr[rightPointer]};
            }
        }
        return new int[2];
    }

    public int[] getTargetSum03(int[] arr, int target) {
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
            if (arr[P1] + arr[P2] < target) {
                P1++;
            } else if (arr[P1] + arr[P2] > target) {
                P2--;
            } else {
                return new int[]{arr[P1], arr[P2]};
            }
        }
        return new int[2];
    }

    // 在个递增排序的数组和一个数字s  输出一组即可，最简单的做法就是使用双指针进行处理
    public int[] getTargetSum04(int[] arr, int target) {
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
            if (arr[P1] + arr[P2] > target) {
                P2--;
            } else if (arr[P1] + arr[P2] < target) {
                P1++;
            } else {
                return new int[]{arr[P1], arr[P2]};
            }
        }
        return new int[2];
    }

    public int[] getTargetSum05(int[] arr, int target) {
        // 使用双指针的方式进行处理
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 != P2) {
            if (P1 < P2 && arr[P2] + arr[P1] > target) {
                P2--;
            } else if (P1 < P2 && arr[P1] + arr[P2] < target) {
                P1++;
            } else {
                return new int[]{arr[P1], arr[P2]};
            }
        }
        return new int[2];
    }

    public int[] getTargetSum06(int[] arr, int target) {
        // 通过双指针的方式进行处理
        if (arr == null || arr.length == 0) {
            return new int[2];
        }
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
            if (arr[P1] + arr[P2] < target) {
                P1++;
            } else if (arr[P1] + arr[P2] > target) {
                P2--;
            } else {
                return new int[]{arr[P1], arr[P2]};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        TowSumInArray towSumInArray = new TowSumInArray();
        int[] targetValue = towSumInArray.getTargetSum06(arr, 9);
        System.out.println(Arrays.toString(targetValue));
    }
}
