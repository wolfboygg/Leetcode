package leetcodereview01.jiandan.leetcode07;

import com.sun.source.tree.Tree;

import java.util.HashMap;

// 重建二叉树
// 根据前序和中序遍历重建二叉树
public class RebuildTree {

    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }

    public HashMap<Integer, Integer> indexOrder = new HashMap<>();

    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public TreeNode rebuildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return reBuildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public TreeNode reBuildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode node = new TreeNode();
        int value = preOrder[preLeft];
        node.value = value;
        // 根据value在中序中的位置分出左右
        int index = indexOrder.get(value);
        int leftChildSize = index - inLeft;
        node.left = reBuildTree(preOrder, inOrder, preLeft + 1, preLeft + leftChildSize, inLeft, index - 1);
        node.right = reBuildTree(preOrder, inOrder, preLeft + leftChildSize + 1, preRight, index + 1, inRight);
        return node;
    }

    public TreeNode rebuildTree02(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return realBuild02(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode realBuild02(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        int rootValueIndex = indexOrder.get(rootValue);
        int leftChildCount = rootValueIndex - inLeft;
        TreeNode node = new TreeNode();
        node.value = rootValue;
        node.left = realBuild02(preOrder, preLeft + 1, preLeft + leftChildCount, inOrder, inLeft, rootValueIndex -1 );
        node.right = realBuild02(preOrder, preLeft + leftChildCount + 1, preRight, inOrder, rootValueIndex + 1, inRight);
        return node;
    }


    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        RebuildTree rebuildTree = new RebuildTree();
        // 3920157
        TreeNode treeNode = rebuildTree.rebuildTree02(preOrder, inOrder);
        rebuildTree.preOrderTraversal(treeNode);
    }
}
