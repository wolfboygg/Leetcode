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

    // 二叉搜索树的后续遍历验证
    public boolean verify01(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        return realVerify01(arr, 0, arr.length - 1);
    }

    public boolean realVerify01(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return true;
        }
        int root = arr[right];
        int currentIndex = 0;
        for (int i = left; i < right; i++) {
            if (arr[i] > root) {
                currentIndex = i;
                break;
            }
        }
        // 检测右子树
        for (int i = currentIndex + 1; i < right; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify01(arr, left, currentIndex - 1) && realVerify01(arr, currentIndex, right - 1);
    }

    // 根据二叉搜索树的特性来进行处理
    public boolean verify02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify02(arr, 0, arr.length - 1);
    }

    private boolean realVerify02(int[] arr, int left, int right) {
        if (right - left < 1) {
            return true;// 表示验证完成
        }
        // 根据跟节点找到左右子树，然后递归进行验证
        int root = arr[right];
        int currentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > root) {
                currentIndex = i; // 找到右子树
                break;
            }
        }
        for (int i = currentIndex + 1; i < right; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify02(arr, left, currentIndex - 1) && realVerify02(arr, currentIndex, right - 1);
    }

    public boolean verify03(int[] arr) {
        // 二叉树的后续遍历
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify03(arr, 0, arr.length - 1);
    }

    public boolean realVerify03(int[] arr, int left, int right) {
        if (right - left < 1) {
            return true;
        }
        // 找到跟节点
        int root = arr[right];
        // 找到右子树的第一个节点
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex + 1; i < right - 1; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        // 然后开始分别进行验证
        return realVerify03(arr, left, rightIndex - 1) && realVerify03(arr, rightIndex, right - 1);
    }

    public boolean verify04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify04(arr, 0, arr.length - 1);
    }

    private boolean realVerify04(int[] arr, int start, int end) {
        if (end - start < 1) {
            return true;
        }
        // 找到根然后进行验证
        int root = arr[end];
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex + 1; i <= end - 1; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify04(arr, start, rightIndex - 1) && realVerify04(arr, rightIndex, end - 1);
    }

    // 验证是否是一个二叉搜索的结果，那么就使用二叉搜索树的特性来判断 后续 左右根 根一定是最后一个的，然后在判断左右子树
    // 使用递归进行处理判断
    public boolean verify05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify05(arr, 0, arr.length - 1); // 因为要递归处理，所以这里要使用第二个方法传入当前的start end
    }

    public boolean realVerify05(int[] arr, int start, int end) {
        if (end - start < 1) { // 如果当前已经是最后了 那么就肯定是一个后续遍历
            return true;
        }
        int root = arr[end];
        int rightStartIndex = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > root) {
                rightStartIndex = i;
                break;
            }
        }
        for (int i = rightStartIndex; i <= end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify05(arr, start, rightStartIndex - 1) && realVerify05(arr, rightStartIndex, end - 1);
    }

    public boolean verify06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify06(arr, 0, arr.length - 1);
    }

    public boolean realVerify06(int[] arr, int start, int end) {
        if (end - start < 1) {
            return true;
        }
        int root = arr[end];
        int rightIndex = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }

        for (int i = rightIndex; i <= end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }

        return realVerify06(arr, start, rightIndex - 1) && realVerify06(arr, rightIndex, end - 1);
    }

    public boolean verify07(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 进行拆分进行处理
        return realVerify07(arr, 0, arr.length - 1);
    }

    public boolean realVerify07(int[] arr, int start, int end) {
        // 左右子树进行检测
        if (start >= end) {
            return true;
        }
        int root = arr[end];
        int rightIndex = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex; i <= end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify07(arr, start, rightIndex - 1) && realVerify07(arr, rightIndex, end - 1);
    }

    public boolean verify08(int[] arr) {
        // 验证一个这个序列是不是二叉树的后序遍历顺序
        // 检查是不是二叉树的后序遍历顺序 左右根，需要通过递归的方式进行追个检查子树的顺序
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify08(arr, 0, arr.length - 1);
    }

    public boolean realVerify08(int[] arr, int start, int end) {
        // 检查每一个子树
        if (start >= end) {
            return true;
        }
        int root = arr[end];
        // 通过遍历找到最大的index
        int rightIndex = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        // 还需要检查后面的结果是否正确
        for (int i = rightIndex + 1; i < end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify08(arr, start, rightIndex - 1) && realVerify08(arr, rightIndex, end - 1);
    }

    public boolean verify09(int[] arr) {
        // 验证一下这个序列是不是一个二叉树的后续遍历顺序
        // 找到根，然后在分左右在分别进行检测
        // 后续遍历的根在最后
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify09(arr, 0, arr.length - 1);
    }

    public boolean realVerify09(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }

        int rootValue = arr[end];
        int rightIndex = -1;
        for (int i = start; i < end; i++) {
            if (arr[i] > rootValue) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex + 1; i < end; i++) {
            if (arr[i] < rootValue) {
                System.out.println("realVerify09....:" + arr[i] + ":rightIndex:" + rightIndex);
                return false;
            }
        }
        // 分了左右然后在分别进行检测
        return realVerify09(arr, start, rightIndex - 1) && realVerify09(arr, rightIndex, end - 1);
    }

    // 验证二叉树后续遍历的顺序问题
    public boolean verify10(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 如何验证 左右跟 还是要区分左右进行验证 递归进行验证
        return realVerify10(arr, 0, arr.length - 1);
    }

    public boolean realVerify10(int[] arr, int start, int end) {
        if (start > end) {
            return true;
        }
        int root = arr[end];
        int rightIndex = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex; i < end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify(arr, start, rightIndex - 1) && realVerify(arr, rightIndex, end - 1);
    }

    // 验证是否是二叉搜索树的后续遍历顺序 左右根  右 > 根 > 左
    public boolean verify11(int[] arr) {
        // 验证是否是后续遍历 主要是区分左右子树然后在进行验证
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify11(arr, 0, arr.length - 1);
    }

    public boolean realVerify11(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        // 区分左右进行验证
        int root = arr[right];
        int rightIndex = 0;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex + 1; i <= right; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify(arr, left, rightIndex - 1) && realVerify(arr, rightIndex, right - 1);
    }

    public boolean verify12(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return realVerify12(arr, 0, arr.length-1);
    }

    public boolean realVerify12(int[] arr, int left, int right) {
        if (left >= right) { //这里要注意等于的情况
            return true;
        }
        // 根结点
        int root = arr[right];
        int rightIndex = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] > root) {
                rightIndex = i;
                break;
            }
        }
        for (int i = rightIndex; i <= right; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return realVerify12(arr, left, rightIndex -1) && realVerify12(arr, rightIndex, right -1);
    }


    public static void main(String[] args) {
        int[] arr = {4,6,5,9,8};
        int[] arr2 = {44,9,6,5,8};
        System.out.println(new VerifySequenceOfBST().verify11(arr));
    }
}
