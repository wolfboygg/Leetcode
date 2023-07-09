package leetcodereview01.jiandan.leetcode07;

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

    public TreeNode rebuildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return rebuild04(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
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


    public TreeNode rebuildTree2(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int value = preOrder[preLeft];
        int index = indexOrder.get(value);
        int leftChildSize = index - inLeft;
        TreeNode root = new TreeNode();
        root.value = value;
        root.left = rebuildTree2(preOrder, inOrder, preLeft + 1, preLeft + leftChildSize, inLeft, index - 1);
        root.right = rebuildTree2(preOrder, inOrder, preLeft + leftChildSize + 1, preRight, index + 1, inRight);
        return root;
    }

    // [5, 3, 1, 2, 6]
    // [3, 2, 1, 5, 6]
    public TreeNode rebuildTree03(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // preOrder中拿到root，再去inOrder区分左右
        int root = preOrder[preLeft];
        int index = indexOrder.get(root);
        TreeNode node = new TreeNode();
        node.value = root;
        int childSize = index - inLeft;
        node.left = rebuildTree03(preOrder, inOrder, preLeft + 1, preLeft + childSize, inLeft, index - 1);
        node.right = rebuildTree03(preOrder, inOrder, preLeft + childSize + 1, preRight, index + 1, inRight);
        return node;
    }

    public TreeNode rebuild04(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int root = preOrder[preLeft];
        int index = indexOrder.get(root);
        int childSize = index - inLeft;
        TreeNode node = new TreeNode();
        node.value = root;
        node.left = rebuild04(preOrder, inOrder, preLeft + 1, preLeft + childSize, inLeft, index - 1);
        node.right = rebuild04(preOrder, inOrder, preLeft + childSize + 1, preRight, index + 1, inRight);
        return node;
    }

    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        RebuildTree rebuildTree = new RebuildTree();
        TreeNode treeNode = rebuildTree.rebuildTree(preOrder, inOrder);
        rebuildTree.preOrderTraversal(treeNode);
    }
}
