package leetcodereview01.jiandan.leetcode33;

/**
 * 验证二叉搜索数的后序遍历
 */
public class VerifySequenceOfBST {

    public boolean verify(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify(arr, 0, arr.length - 1);
    }

    private boolean realVerify(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return true;
        }
        int root = arr[right];
        int currentIndex = 0;
        for (int i = 0; i < right; i++) {
            if (arr[i] > root) {
                currentIndex = i;
                break;
            }
        }
        for (int i = currentIndex; i < right; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify(arr, 0, currentIndex - 1) && realVerify(arr, currentIndex, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(new VerifySequenceOfBST().verify(arr));
    }
}
