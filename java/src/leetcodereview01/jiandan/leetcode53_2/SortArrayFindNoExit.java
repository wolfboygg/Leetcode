package leetcodereview01.jiandan.leetcode53_2;

public class SortArrayFindNoExit {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                System.out.println("不存在的是:" +i);
                break;
            }
        }
    }
}
