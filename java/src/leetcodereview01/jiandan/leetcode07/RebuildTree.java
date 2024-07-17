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
        return rebuildTree06(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
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

    public TreeNode rebuild05(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        // 重建的方式就是找到左右子树，依次进行重建 递归进行构建
        if (preLeft > preRight) {
            return null;
        }
        int root = preOrder[preLeft];
        // 找到对应的位置
        int inOrderPosition = indexOrder.get(root);
        // 找到左孩子的数量
        int childSize = inOrderPosition - inLeft;
        TreeNode node = new TreeNode();
        node.value = root;
        node.left = rebuild05(preOrder, inOrder, preLeft + 1, preLeft + childSize, inLeft, inOrderPosition - 1);
        node.right = rebuild05(preOrder, inOrder, preLeft + childSize + 1, preRight, inOrderPosition + 1, inRight);
        return node;
    }

    public TreeNode rebuildTree06(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        // 前序和中序重建
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        int indexOrderRootPosition = indexOrder.get(rootValue);// 在中序遍历里面的数据，氛围左右子树
        int leftChildSize = indexOrderRootPosition - inLeft;
        TreeNode root = new TreeNode();
        root.value = rootValue;
        root.left = rebuildTree06(preOrder, preLeft + 1, preLeft + leftChildSize, inOrder, inLeft, indexOrderRootPosition - 1);
        root.right = rebuildTree06(preOrder, preLeft + leftChildSize + 1, preRight, inOrder, indexOrderRootPosition + 1, inRight);
        return root;
    }

    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public TreeNode rebuildTree07(int[] preOrder, int[] inOrder) {
        // 遍历存储inOrder的index
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return rebuildTree07(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode rebuildTree07(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 通过递归的方式进行处理
        int root = preOrder[preLeft];
        int rootIndexInOrder = indexOrder.get(root);
        int leftChildSize = rootIndexInOrder - inLeft; // 这里有一个算对的问题，其实size数量会多1为了下面的位置好算
        // 算出当前的位置，然后进行重建
        TreeNode node = new TreeNode();
        node.value = root;
        node.left = rebuildTree07(preOrder, preLeft + 1, preLeft + leftChildSize, inOrder, inLeft, rootIndexInOrder - 1);
        node.right = rebuildTree07(preOrder, preLeft + leftChildSize + 1, preRight, inOrder, rootIndexInOrder + 1, inRight);
        return node;
    }

    public TreeNode rebuildTree08(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return rebuildTree08(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode rebuildTree08(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootValue = preOrder[preStart];
        int rootIndex = indexOrder.get(rootValue);
        int leftChildSize = rootIndex - inStart;
        TreeNode root = new TreeNode();
        root.value = rootValue;
        // 这里要使用rootIndex 而不是使用size 切记切记
        root.left = rebuildTree08(preOrder, preStart + 1, preStart + leftChildSize, inOrder, inStart, rootIndex - 1);
        root.right = rebuildTree08(preOrder, preStart + leftChildSize + 1, preEnd, inOrder, rootIndex + 1, inEnd);
        return root;
    }

    public TreeNode rebuildTree09(int[] preOrder, int[] inOrder) {
        // 重建二叉树
        if (preOrder == null || inOrder == null) {
            return null;
        }
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return rebuildTree09(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode rebuildTree09(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        // 通过递归的方式进行处理
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        int rootIndex = indexOrder.get(rootValue);
        int leftSize = rootIndex - inLeft;// 左孩子的个数
        TreeNode node = new TreeNode();
        node.value = rootValue;
        node.left = rebuildTree09(preOrder, preLeft + 1, preLeft + leftSize, inOrder, inLeft, rootIndex - 1);
        node.right = rebuildTree09(preOrder, preLeft + leftSize + 1, preRight, inOrder, rootIndex + 1, inRight);
        return node;
    }

    public TreeNode rebuildTree10(int[] preOrder, int[] inOrder) {
        // 根据前序和中序还原二叉树
        // 首先需要存一下中序列遍历的位置
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        return rebuildTree10(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode rebuildTree10(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        TreeNode node = new TreeNode();
        node.value = rootValue;

        // 区分左右进行递归构建
        int rootInOderIndex = indexOrder.get(rootValue);// 用来区分左右
        // {3, 9, 20, 15, 7};
        // {9, 3, 15, 20, 7};
        int leftSize = rootInOderIndex - inLeft;
        TreeNode left = rebuildTree10(preOrder, preLeft + 1, preLeft + leftSize, inOrder, inLeft, rootInOderIndex - 1);
        TreeNode right = rebuildTree10(preOrder, preLeft + leftSize + 1, preRight, inOrder, rootInOderIndex + 1, inRight);

        node.left = left;
        node.right = right;
        return node;
    }

    // 根据前序和中序遍历重建二叉树
    public TreeNode rebuildTree11(int[] preOrder, int[] inOrder) {
        // 需要找到跟节点然后使用递归的方式进行遍历
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        // 存一下顺序
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        TreeNode node = realRebuild(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        return node;
    }

    public TreeNode realRebuild(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        // 跟左右  左跟右
        if (preStart > preEnd) {
            return null;
        }
        int rootValue = preOrder[preStart];
        int rootIndex = indexOrder.get(rootValue);
        int leftChildCount = rootIndex - inStart;
        TreeNode root = new TreeNode();
        root.value = rootValue;
        root.left = realRebuild(preOrder, preStart + 1, preStart + leftChildCount, inOrder, inStart, rootIndex - 1);
        root.right = realRebuild(preOrder, preStart + leftChildCount + 1, preEnd, inOrder, rootIndex + 1, inEnd);
        return root;
    }

    public TreeNode rebuildTree12(int[] preOrder, int[] inOrder) {
        // 重新构建二叉树，通过递归的方式进行处理
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        // 需要存储一下index，为了计算左右子树的节点个数
        for (int i = 0; i < inOrder.length; i++) {
            indexOrder.put(inOrder[i], i);
        }
        TreeNode node = realRebuild12(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        return node;
    }

    // 3  9  20  15  7
    // 9, 3, 15, 20, 7
    public TreeNode realRebuild12(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        int rootInOrderIndex = indexOrder.get(rootValue);
        int leftNum = rootInOrderIndex - inLeft;
        TreeNode root = new TreeNode();
        root.value = rootValue;
        root.left = realRebuild12(preOrder, preLeft + 1, preLeft + leftNum, inOrder, inLeft, rootInOrderIndex - 1);
        root.right = realRebuild12(preOrder, preLeft + 1 + leftNum, preRight, inOrder, rootInOrderIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        RebuildTree rebuildTree = new RebuildTree();
        // 3920157
        TreeNode treeNode = rebuildTree.rebuildTree12(preOrder, inOrder);
        rebuildTree.preOrderTraversal(treeNode);
    }
}
