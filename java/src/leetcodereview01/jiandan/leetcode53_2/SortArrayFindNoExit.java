package leetcodereview01.jiandan.leetcode53_2;

public class SortArrayFindNoExit {
    public static void main(String[] args) {
//        int[] arr = {0, 1, 3};
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != i) {
//                System.out.println("不存在的是:" +i);
//                break;
//            }
//        }

        // 缺失的数字
        int[] arr = {0, 1, 3};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                System.out.println("当前数字不存在:" + i);
            }
        }
    }
}
