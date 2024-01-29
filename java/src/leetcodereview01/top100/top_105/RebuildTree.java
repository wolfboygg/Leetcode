package leetcodereview01.top100.top_105;

import leetcodereview01.top100.top_104.TreeNodeDepth;

import java.util.HashMap;

/**
 * 根据前序和中序遍历的结果重建二叉树
 */
public class RebuildTree {

    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return realBuild(preOrder, 0, preOrder.length -1, inOrder, 0, inOrder.length - 1);
    }

    /**build
     *      3
     *     4 5
     *    12 67
     */
    // 3412567
    // 1423657

    public TreeNode realBuild(int[] preOrder, int preStar, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preEnd - preStar < 0) {
            return null;
        }
        int value = preOrder[preStar];
        int indexInOrder = map.get(value);
        int leftChildCount = indexInOrder - inStart;
        TreeNode root = new TreeNode(value);
        root.left = realBuild(preOrder, preStar + 1, preStar + leftChildCount, inOrder, inStart, indexInOrder - 1);
        root.right = realBuild(preOrder, preStar + leftChildCount + 1, preEnd, inOrder, indexInOrder + 1, inEnd);
        return root;
    }

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        traversal(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args){
      int[] preOrder = {3,4,1,2,5,6,7};
      int[] inOrder = {1,4,2,3,6,5,7};
        RebuildTree rebuildTree = new RebuildTree();
        TreeNode node = rebuildTree.build(preOrder, inOrder);
        rebuildTree.traversal(node);
    }
}
