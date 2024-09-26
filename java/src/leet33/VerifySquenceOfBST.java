package leet33;

/**
 * 验证一个序列是否是二叉搜索树的的后序遍历结果
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int curIndex = first;
        int rootValue = sequence[last];
        // 找到左右子树
        // 不需要等于last是应为last为根节点
        for (int i = 0; i < last; i++) {
            if (sequence[i] > rootValue) {
                curIndex = i;
                break;
            }
        }
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < rootValue) {
                return false;
            }
        }
        // last -1 是因为根结点去掉了
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }

    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        VerifySquenceOfBST bst = new VerifySquenceOfBST();
        System.out.println(bst.verifySquenceOfBST(sequence));
        int[] sequence1 = {7, 4, 6, 6};
        System.out.println(bst.verifySquenceOfBST(sequence1));
    }

}
